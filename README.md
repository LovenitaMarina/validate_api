# ValidateApi Class Documentation

##Overview
The ValidateApi class is a test class designed to validate the response of an API endpoint 'https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=true' using the RestAssured library. It performs assertions to ensure the response meets the specified acceptance criteria.


##Features
	• Sends a GET request to the API endpoint.
	• Parses the JSON response using RestAssured's JsonPath.
	• Validates specific fields in the response body against the acceptance criteria.
	• Logs the results for debugging and verification.


##Acceptance Criteria
The test validates the following:

1. The Name field in the response is "Carbon credits".
2. The CanRelist field is true.
3. The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category".


## Prerequisites

  • Java 8 or later
	• Maven 3.6 or later
	• RestAssured 4.3 or later
	

## Execution

1. Clone the repository using 'git clone https://github.com/your-username/validate-api.git'
2. Navigate to the project directory using 'cd validate-api'
3. Build the project using 'mvn clean install'
4. Execute the test using 'mvn test'

## Results

The test results will be printed to the console.
