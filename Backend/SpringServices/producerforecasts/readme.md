# Producer Forecasts

This is a Spring Boot Java application.

Main dependencies:
 - Spring for Apache Kafka

Its main goal is to fetch forecast data from the dedicated Fintech service on a scheduled basis and send the records to a Kafka topic.

# How to package

1) Execute the command `./mvnw clean package` 
2) The .jar file will be in the `target` folder

# Project Structure

## [<em>fintechapi</em>](./src/main/java/its/statea/producerforecasts/fintechapi/readme.md)

It contains the classes needed to interact with the Fintech API

## [<em>kafka</em>](./src/main/java/its/statea/producerforecasts/kafka/readme.md)

It contains the classes that manage Kafka write operations

## [<em>message</em>](./src/main/java/its/statea/producerforecasts/message/readme.md)

It contains the entities needed for serialization of Kafka messages 

## [<em>scheduledtasks</em>](./src/main/java/its/statea/producerforecasts/scheduledtasks/readme.md)

It contains the main Scheduled tasks of the application

## <em>resources</em>

It contains all the Spring Boot configurations:

- <strong>application-dev.properties:</strong> configurations during development
- <strong>application.properties:</strong> configurations during production