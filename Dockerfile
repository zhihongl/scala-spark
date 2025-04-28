FROM openjdk:11-jdk-slim

# Install sbt
RUN apt-get update && \
    apt-get install -y curl gnupg2 && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x99E82A75642AC823" | apt-key add && \
    apt-get update && \
    apt-get install -y sbt && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . /app

RUN sbt compile

CMD ["sbt", "-Dsbt.color=always", "-Dsbt.log.format=true", "reStart"]