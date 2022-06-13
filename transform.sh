#!/usr/bin/env bash
# Environment Variables
# RemoteDriverUrl

# Run tests using maven command
mvn clean test \
    -DExecutionEnv="docker"
    -DchromeDriverPath="/app/bin/chromedriver"

