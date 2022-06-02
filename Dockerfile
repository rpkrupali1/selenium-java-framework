FROM openjdk:11
#Step 1 : Install the pre-requisite
RUN apt-get update
RUN apt-get install -y curl
RUN apt-get install -y p7zip \
    p7zip-full \
    unace \
    zip \
    unzip \
    bzip2

# Get stable version
ARG CHROME_VERSION="google-chrome-stable"

# Download chrome
RUN curl http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_$CHROME_VERSION-1_amd64.deb -o /chrome.deb
RUN dpkg -i /chrome.deb
RUN rm /chrome.deb

#Download chrome driver

# Run tests
FROM maven:3.8-jdk-11-slim
WORKDIR /app
COPY src /app/src
COPY pom.xml /app