# Integer to Roman Number API (REST)
A sample REST API/Micro Service (Java/SpringBoot) implementation to convert Integer to Roman number.
This is just a sample implementation therefore use it at your own discretion.

# Features
Main features of this application
- Swagger/Open API implementation: Swagger UI for this project can be accessed here: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Control behavior of API using externalized configurations (using property file or environment variables)
- Unit testing with code coverage report (using JaCoCo)
- Feature (REST API# 1, Supported Range 1-255): http://localhost:8080/romannumeral?romannumeral=212 (Range can be controlled using configuration in `application.properties` file. See `limit.integer.range` configuration)
- Feature (REST API# 2 - Extension 1, Range 1-3999): Support for Any Integer number: http://localhost:8080/romannumeral-extension-one?romannumeral=3999 (Range can be controlled using configuration in `application.properties` file. See `limit.integer.range.extension.one` configuration)
- Monitoring (Extension 3, using Spring Actuator): http://localhost:8080/actuator (Also, refer section [DevOps and Monitoring](#devops-and-monitoring) below)
- Docker: Refer section [Docker](#docker) below

# Getting Started
To build and run this project you would need:
- Java 1.8+
- Maven 3.6+
- Docker (optional, if you want to build and run Docker image)

# Build and Installation
- Build maven project using command: `mvn clean install`
- Run the project from command line: `mvn spring-boot:run`
- Profile/Environment specific execution (e.g. environment based config): `mvn spring-boot:run -Dspring-boot.run.profiles=uat`
(**NOTE:** `uat` profile in the command and in this case the application will run on `port 80` instead of `8080`)

# Testing
## Unit Tests
- This project uses JUnit library and [JaCoCo](https://github.com/jacoco/jacoco) Maven plugin to execute and generate test coverage report respectively.
- To run unit test and generate coverage report run `mvn clean command`. The command will execute test cases and will generate coverage report under target folder i.e. `<PROJECT ROOT>/target/site/index.html`
- To run only unit test cases, run `mvn test` command
- To see sample report generate open `index.html` file in `code-coverage-report` folder

## Integration Tests
- TBD (Need to add some integration test that can be run separately from unit tests)
- Need to ensure that these test can be integrated with CI/CD pipeline

# Docker
- Build docker image: `docker build -t adobe-assessment/roman-numeral .` (**NOTE:** Image name is `adobe-assessment/roman-numeral`)
- Run docker image: `docker run -p 8080:8080 -t adobe-assessment/roman-numeral`

# DevOps and Monitoring
This project uses spring and associated libraries for enabling monitoring and DevOps related capabilities. 
[Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html) provides many out-of-the-box capabilities
for monitoring and provides handful of applications metrics that can be used for SRE/DevOps team.

**NOTE** Other metrics/monitoring tools can also be enabled on the project third party products are used by organization/project like Dynatrace, New Relic etc.

There are various health and monitoring information that can be access. E.g.:
- [Health Status](http://localhost:8080/actuator): This indicates whether the application is UP or not. Typically useful for auto-scaling in cloud and container based environments.
- [HTTP Trace](http://localhost:8080/actuator/httptrace): Displays HTTP trace information (by default, the last 100 HTTP request-response exchanges). Requires an HttpTraceRepository bean

There are many other monitoring/metrics options that can be enabled and controlled which one to expose. [Please see full list of options here](http://localhost:8080/actuator)

# Access Application Metrics
Use below links to access popular application metrics ([click here to to see full list of metrics](http://localhost:8080/actuator/metrics))
- jvm.memory.max: [JVM Max Memory](http://localhost:8080/actuator/metrics/jvm.memory.max)
- jvm.memory.used: [JVM Used Memory](http://localhost:8080/actuator/metrics/jvm.memory.used)
- jvm.threads.states: [JVM Thread States](http://localhost:8080/actuator/metrics/jvm.threads.states)
- process.start.time: [Process Start Time](http://localhost:8080/actuator/metrics/process.start.time)
- process.uptime: [Process Up Time](http://localhost:8080/actuator/metrics/process.uptime)
- system.cpu.usage: [CPU Usage](http://localhost:8080/actuator/metrics/system.cpu.usage)
- jvm.threads.live: [Live Threads](http://localhost:8080/actuator/metrics/jvm.threads.live)
- jvm.threads.peak: [Peak Threads](http://localhost:8080/actuator/metrics/jvm.threads.peak)
- process.files.open: [Files Open by Process](http://localhost:8080/actuator/metrics/process.files.open)
- Other metrics: [click here to to see full list of metrics](http://localhost:8080/actuator/metrics)

# Improvements/TODO
- Circuit breaker can be used so that API can continue operating when a related service fails, preventing the failure from cascading
- External config server can be leveraged (in addition to already used property file or environment based configurations)

# References
- Logic to convert decimal number to Roman number: [https://www.rapidtables.com/convert/number/how-number-to-roman-numerals.html](https://www.rapidtables.com/convert/number/how-number-to-roman-numerals.html).
**NOTE:** I have used this page to learn and understand the logic to convert large decimal numbers to Roman representation.
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)

