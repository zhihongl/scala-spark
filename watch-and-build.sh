#!/bin/bash

# Watch for changes in Scala files and rebuild Docker image
while true; do
  fswatch -1 src/main/scala/*.scala
  echo "Detected changes in Scala files. Rebuilding Docker image..."
  docker build -t scala-spark-demo .
  echo "Docker image rebuilt successfully."
done

# Make the script executable
chmod +x watch-and-build.sh