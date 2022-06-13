#Choose Base
FROM maven:3.8-jdk-11-slim

WORKDIR /app
# Install certificate if you are having some security of the network
RUN curl -sSLk https://tools.circleci.foc.zone/install-certs | bash -


#Install the pre-requisites.
RUN apt-get update
RUN apt-get install -y curl
RUN apt-get install -y p7zip \
    ca-certificates \
    p7zip-full \
    unace \
    zip \
    unzip \
    bzip2 \
    wget

#Version numbers
ARG CHROME_VERSION='current'
#ARG CHROMDRIVER_VERSION=83.0.4103.39
ARG CHROME_DRIVER_VERSION
ARG FIREFOX_VERSION=78.0.2
ARG FIREFOXDRIVER_VERSION=0.26.0

#Download & Install Chrome browser
#RUN curl http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_$CHROME_VERSION-1_amd64.deb -o /chrome.deb
#RUN dpkg -i /chrome.deb
#RUN rm /chrome.deb

RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb

#RUN echo "deb [arch=amd64] https://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list \
#    && apt-get update && apt-get install -y \
#    google-chrome-stable \
#    --no-install-recommends \
#    && apt-get purge --auto-remove -y curl \
#    && rm -rf /var/lib/apt/lists/*

#RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
#RUN dpkg -i google-chrome-stable_current_amd64.deb
#RUN apt -f install -y

#Download Chrome driver
#RUN mkdir -p /app/bin
#RUN curl https://chromedriver.storage.googleapis.com/$CHROMDRIVER_VERSION/chromedriver_linux64.zip -o /tmp/chromedriver.zip \
#    && unzip /tmp/chromedriver.zip -d /app/bin/ \
#    && rm /tmp/chromedriver.zip
#RUN chmod +x /app/bin/chromedriver

RUN if [ -z "$CHROME_DRIVER_VERSION" ]; \
  then CHROME_MAJOR_VERSION=$(google-chrome --version | sed -E "s/.* ([0-9]+)(\.[0-9]+){3}.*/\1/") \
    && CHROME_DRIVER_VERSION=$(wget --no-verbose -O - "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_${CHROME_MAJOR_VERSION}"); \
  fi \
  && echo "Using chromedriver version: "$CHROME_DRIVER_VERSION \
  && wget --no-verbose -O /tmp/chromedriver_linux64.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
  && unzip /tmp/chromedriver_linux64.zip -d /app/bin \
  && rm /tmp/chromedriver_linux64.zip \
   && chmod +x /app/bin/chromedriver

#RUN wget -q --continue -P $CHROMEDRIVER_DIR "http://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip"
#RUN unzip $CHROMEDRIVER_DIR/chromedriver* -d $CHROMEDRIVER_DIR

#Download & Install Firefox browser
#RUN wget --no-verbose -O /tmp/firefox.tar.bz2 https://download-installer.cdn.mozilla.net/pub/firefox/releases/$FIREFOX_VERSION/linux-x86_64/en-US/firefox-$FIREFOX_VERSION.tar.bz2 \
#  && bunzip2 /tmp/firefox.tar.bz2 \
#  && tar xvf /tmp/firefox.tar \
#  && mv /firefox /opt/firefox-$FIREFOX_VERSION \
#  && ln -s /opt/firefox-$FIREFOX_VERSION/firefox /usr/bin/firefox

#Download Firefox driver (Geckodriver)
#RUN wget https://github.com/mozilla/geckodriver/releases/download/v$FIREFOXDRIVER_VERSION/geckodriver-v$FIREFOXDRIVER_VERSION-linux64.tar.gz \
#    && tar -xf geckodriver-v0.26.0-linux64.tar.gz \
#    && cp geckodriver /app/bin/geckodriver
#RUN chmod +x /app/bin/geckodriver

#Download & Install Maven(We dont need this step as we chose maven base) Also set the env variables.
#ARG USER_HOME_DIR="/root"
#ENV MAVEN_HOME /usr/share/maven
#ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

#Copy our project to Docker.

COPY src /app/src
COPY pom.xml /app
ADD transform.sh transform.sh

ENTRYPOINT sh transform.sh