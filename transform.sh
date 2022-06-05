#!/usr/bin/env bash
# Environment Variables
# RemoteDriverUrl

while [ "$( curl -s $RemoteDriverUrl/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# Run tests using maven command
mvn clean test \
    -DExecutionEnv="remote" \
    -DRemoteDriverUrl=$RemoteDriverUrl
