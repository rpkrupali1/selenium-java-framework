#Run tests using selenium grid
#FROM openjdk:11

# ubuntu base image
FROM maven:3.8-jdk-11-slim
RUN apt-get update
RUN apt-get install -y curl \
    jq
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
ADD transform.sh transform.sh

ENTRYPOINT sh transform.sh
