package org.kotlincode.exercises

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.AtomicLong
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.atomics.incrementAndFetch
import kotlin.random.Random


class ReadFilesStream {

    fun wordGenerator(len: Int, rnd: Random = Random(SEED)): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (0..len)
            .map { chars[rnd.nextInt(chars.length)] }
            .joinToString("")
    }

    fun fileGenerator() {
        val file = File(OUTPUT_PATH)
        file.exists() && file.delete()
        file.parentFile?.mkdirs()

        OutputStreamWriter(file.outputStream().buffered(), StandardCharsets.UTF_8).use { writer ->
            // writhe the column headers
            val header = (0 until COLUMNS).joinToString(DELIMITER) { "column-$it" }
            writer.write(header)
            writer.appendLine()

            (0 until ROWS).forEach { row ->
                (0 until COLUMNS).forEach { col ->
                    writer.write("${wordGenerator(Random.nextInt(10, 30))}$DELIMITER")
                }
                writer.appendLine()
            }
        }
    }

    @OptIn(ExperimentalAtomicApi::class)
    suspend fun readData(
        path: String = OUTPUT_PATH,
        limitRowsPerWorker: Int = 10,
        workerCount: Int = Runtime.getRuntime().availableProcessors(),
        processRow: (Int, List<String>, AtomicLong?) -> Unit = { _, _, _ -> }
    ) = coroutineScope {
        val file = File(path)
        val globalRowsCounter = AtomicLong(0)
        val isMissingRowsToBeProcessed = AtomicBoolean(true)

        repeat (workerCount) { workerId ->
            launch(Dispatchers.IO) {
                val rowStart = workerId * limitRowsPerWorker
                var readRows = 0L

                file.bufferedReader(charset = StandardCharsets.UTF_8).useLines { lines ->
                    val slice = lines.drop(rowStart)

                    slice.takeWhile { readRows < limitRowsPerWorker }.forEach {
                            line ->
                        readRows = readRows.inc()
                        val values = line.split(DELIMITER)
                        globalRowsCounter.incrementAndFetch()
                        processRow(workerId, values, globalRowsCounter)
                    }


                    // Check if there is remaining rows to be processed
                    if (readRows < limitRowsPerWorker) {
                        isMissingRowsToBeProcessed.exchange(false)
                    }

                    readRows = 0L
                }
            }
        }

        if (isMissingRowsToBeProcessed.load()) {
            // recursive approach

        }

        println("Read data from file: $OUTPUT_PATH")
    }

    companion object {
        const val SEED = 2
        const val OUTPUT_PATH = "large-data.csv"
        const val ROWS = 100_000
        const val COLUMNS = 10
        const val DELIMITER = ","
    }
}