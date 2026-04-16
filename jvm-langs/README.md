# JVM Algorithms Implementation

This directory contains implementations of fundamental algorithms and data structures for JVM languages (Java and Kotlin). The JVM ecosystem provides robust libraries, strong typing, and excellent performance for algorithmic implementations.

## Running the Code

### Using Gradle (Legacy)
```bash
cd jvm-langs
./gradlew build
./gradlew test
```

### Using Individual Files
```bash
# Java
javac java/strings/StringManipulation.java
java -cp . org.algorithms.strings.StringManipulation

# Kotlin
kotlinc kotlin/maps/TwoSum.kt -include-runtime -d TwoSum.jar
java -jar TwoSum.jar
```
