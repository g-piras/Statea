# Webserver

This is a Spring Boot Java application.

Main dependencies:
 - Hibernate Validator
 - Spring Web
 - Spring Data JPA
 - MariaDB Driver

This application exposes DB data through a REST API. [^1]

You can find more details about the API on [swaggerhub](https://app.swaggerhub.com/apis/emilio.gasbarro/touristats/v1) or on the local [html file](./swagger_docs.html).

# How to package

1) Execute the command `./mvnw clean package` 
2) The .jar file will be in the `target` folder

# Project Structure

## <em>db</em>

It contains all the helper classes needed to model and interact with the SQL Database.

 - [entity](./src/main/java/its/statea/webserver/db/entity/readme.md)
 - [repository](./src/main/java/its/statea/webserver/db/repository/readme.md)
 - [service](./src/main/java/its/statea/webserver/db/service/readme.md)

## <em>helper</em>

It contains all the helper classes for both the <em>web</em> and <em>db</em> portions of the application.

 - [datamap](./src/main/java/its/statea/webserver/helper/datamap/readme.md)

## <em>web</em>

It contains all the classes needed to define the web API.

 - [common](./src/main/java/its/statea/webserver/web/common/readme.md)
 - [v1](./src/main/java/its/statea/webserver/web/v1/readme.md)

## <em>resources</em>

It contains all the Spring Boot configurations:

- <strong>application-dev.properties:</strong> configurations during development
- <strong>application.properties:</strong> configurations during production

[^1]: only read operations are supported