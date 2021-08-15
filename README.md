# roman-numeral
A sample REST API/Micro Service (Java/SpringBoot) implementation to convert Integer to Roman number

# Getting Started

# Features

# Build and Installation
- Build maven project using command: `mvn clean install`
- Run the project from command line: `mvn spring-boot:run`

# Docker
- Build docker image: `docker build -t adobe-assessment/roman-numeral .` (**NOTE**: Image name is `adobe-assessment/roman-numeral`)
- Run docker image: `docker run -p 8080:8080 -t adobe-assessment/roman-numeral`

# Testing

# DevOps & Monitoring
This project uses spring and associated libraries for enabling monitoring and DevOps related capabilities. 
[Spring Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html) provides many out-of-the-box capabilities
for monitoring and provides handful of applications metrics that can be used for SRE/DevOps team.

**NOTE** Other metrics/monitoring tools can also be enabled on the project third party products are used by organization/project like Dynatrace, New Relic etc.

There are various health and monitoring information that can be access. E.g.:
- [Health Status](http://localhost:8080/actuator): This indicates whether the application is UP or not. Typically useful for auto-scaling in cloud and container based environments.
- [HTTP Trace](http://localhost:8080/actuator/httptrace): Displays HTTP trace information (by default, the last 100 HTTP request-response exchanges). Requires an HttpTraceRepository bean

There are many other monitoring/metrics options that can be enabled and controlled which one to expose. [Please see full list of options here](http://localhost:8080/actuator)

# 
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


