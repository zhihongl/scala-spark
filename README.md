# Scala Spark Demo Project

This project demonstrates Apache Spark with Scala, designed for learning purposes and fully containerized using Docker.

## Features
- Scala 2.12, Spark 3.3.2, sbt 1.8.2, OpenJDK 11
- Sample Spark application: calculates average age from a small dataset
- Hello Spark example: filters and groups an in-memory employee dataset
- All dependencies managed via sbt
- Easy to build and run inside Docker

## Getting Started

### Prerequisites
- Docker installed on your machine

### Build and Run

1. Build the Docker image:
   ```sh
   docker build -t scala-spark-demo .
   ```
2. Run the application:
   ```sh
   docker run --rm scala-spark-demo
   ```

## Project Structure
- `Dockerfile`: Containerizes the environment
- `build.sbt`: Project dependencies and settings
- `src/main/scala/SparkDemo.scala`: Main Spark application
- `src/main/scala/HelloSpark.scala`: Hello Spark example (filter + groupBy)
- `project/build.properties`: sbt version

## Running Examples Locally with sbt

Ensure you have **sbt** and **Java 11** installed locally, then:

### Run the Hello Spark example
```sh
sbt "runMain HelloSpark"
```

### Run the default example (ReadAAPLCSV)
```sh
sbt run
```

### Run the Spark Demo
```sh
sbt "runMain SparkDemo"
```

---

Happy Coding!