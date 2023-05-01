#!/bin/bash -e

# Declare and set env variable default
export browser="firefox"

# Parse the variable name and value from the argument
var="$1"
browser_name="${var%%=*}"
browser_value="${var#*=}"

# Set the variable
eval "$browser_name='$browser_value'"

# Update browser when it is coming as command line argument
export browser=$browser_value

# Print the variable value
echo "The $browser_name is: ${browser_value}"

#./gradlew myCustomTask -Pbrowser="$browser_value"
./gradlew clean testngTests --console=plain --debug | grep "url"
