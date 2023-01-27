# Consumer Forecasts

This is a Spring Boot Java application.

Main dependencies:
 - Spring for Apache Kafka
 - Spring Data JPA
 - MariaDB Driver

Its main goal is to read prediction records from a Kafka queue and store them inside a SQL Database (MariaDB).

# How to package

1) Execute the command `./mvnw clean package` 
2) The .jar file will be in the `target` folder

# Project Structure

## <em>db</em>

It contains all the classes needed to model and interact with the SQL Database.

 - [entity](./src/main/java/its/statea/consumerforecasts/db/entity/readme.md)
 - [repository](./src/main/java/its/statea/consumerforecasts/db/repository/readme.md)
 - [service](./src/main/java/its/statea/consumerforecasts/db/service/readme.md)

## <em>queue</em>

It contains all the classes needed to model and interact with the Kafka queue.

 - [consumertasks](./src/main/java/its/statea/consumerforecasts/queue/consumertasks/readme.md)
 - [fintechapi](./src/main/java/its/statea/consumerforecasts/queue/fintechapi/readme.md)
 - [kafka](./src/main/java/its/statea/consumerforecasts/queue/kafka/readme.md)
 - [message](./src/main/java/its/statea/consumerforecasts/queue/message/readme.md)

## <em>resources</em>

It contains all the Spring Boot configurations:

- <strong>application-dev.properties:</strong> configurations during development
- <strong>application.properties:</strong> configurations during production