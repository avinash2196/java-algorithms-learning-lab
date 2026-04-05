#!/bin/sh
# Maven Wrapper script for Unix-like systems
# Downloads Maven automatically if not present locally.

set -e
MAVEN_WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES=".mvn/wrapper/maven-wrapper.properties"

DISTRIBUTION_URL=$(grep distributionUrl "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2)

# Determine JAVA_HOME
if [ -z "$JAVA_HOME" ]; then
  JAVA_CMD=java
else
  JAVA_CMD="$JAVA_HOME/bin/java"
fi

# Download maven-wrapper.jar if missing
if [ ! -f "$MAVEN_WRAPPER_JAR" ]; then
  WRAPPER_URL=$(grep wrapperUrl "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2)
  mkdir -p "$(dirname "$MAVEN_WRAPPER_JAR")"
  if command -v curl > /dev/null 2>&1; then
    curl -fsSL -o "$MAVEN_WRAPPER_JAR" "$WRAPPER_URL"
  elif command -v wget > /dev/null 2>&1; then
    wget -q -O "$MAVEN_WRAPPER_JAR" "$WRAPPER_URL"
  else
    echo "ERROR: curl or wget is required to download the Maven wrapper." >&2
    exit 1
  fi
fi

exec "$JAVA_CMD" -jar "$MAVEN_WRAPPER_JAR" \
  --distributionUrl "$DISTRIBUTION_URL" \
  --baseDistributionUrl "$(dirname "$DISTRIBUTION_URL")/" \
  "$@"
