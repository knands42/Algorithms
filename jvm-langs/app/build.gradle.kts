import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-opt-in=kotlin.concurrent.atomics.ExperimentalAtomicApi")
    }
}

kotlin {
    sourceSets.all {
        languageSettings.optIn("kotlin.concurrent.atomics.ExperimentalAtomicApi")
    }
}

kotlin {
    sourceSets {
        getByName("main") {
            kotlin {
                exclude("**/org/kotlincode/exercises/**")
            }
        }
    }
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
    implementation(libs.kotlinx.coroutine)
    implementation(kotlin("stdlib-jdk8"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
