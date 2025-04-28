# Scala Spark Demo Project

This project demonstrates Apache Spark with Scala, designed for learning purposes and fully containerized using Docker.

## Features
- Scala 2.12, Spark 3.3.2, sbt 1.8.2, OpenJDK 11
- Sample Spark application: calculates average age from a small dataset
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
- `project/build.properties`: sbt version

## Customization
You can modify `SparkDemo.scala` to showcase different Spark features or datasets.

---

Happy Coding!