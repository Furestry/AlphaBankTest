## Requirements
- Java 17 or newer
## Java Docs
You can find the java docs at [link](https://furestry.github.io/AlphaBankTest/)
## Installing
You can download jar or build one yourself
### Download jar
- [Download link](https://github.com/Furestry/AlphaBankTest/releases)
### Download sources
After downloading you need follow these steps:
- Unzip source code
- Go to the source directory
- Use the console command 'gradlew build'
- Your jar file will be in the source directory/build/libs folder and named AlphaBankTest-Version.jar
## Launching
To run the app you need to run the console command 'java -jar fileName'. You can use [options](https://www.oracle.com/java/technologies/javase/vmoptions-jsp.html) as desired.
## Docker
To run the app in Docker you need to run the console command 'docker build --tag "appName"' and then 'docker run appName -p 8080:8080'
## Using
To use the service, you need to send a request to http://yourDomain/ with the path variable 'currency' representing the three-letter currency code. For example http://localhost:8080/?currency=RUB
