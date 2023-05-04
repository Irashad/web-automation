#!/bin/bash -e

#check if at least one argument passed to to bash script
if [ "$#" -eq 1 ]; then
  # Parse the variable name and value from the argument
  var="$1"
  browser_name="${var%%=*}"
  browser_value="${var#*=}"

  # Set the variable
  eval "$browser_name='$browser_value'"

  # Update browser when it is coming as command line argument
  export browser=$browser_value

else
  # Declare and set env variable as default if its not passed as command line arg
  export browser="chrome"
fi

# Print the variable value
echo "The $browser_name is: ${browser_value}"

./gradlew clean EndToEnd
