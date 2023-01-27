# Producer Stats

This is a Spring Boot Java application.

Main dependencies:
 - Spring for Apache Kafka
 - Redis Lettuce

Its main goal is to fetch new data from the Istat API on a scheduled basis and send the records found to a Kafka topic.

# How to package

1) Execute the command `./mvnw clean package` 
2) The .jar file will be in the `target` folder

# Project Structure

## [<em>countriesapi</em>](./src/main/java/its/statea/producer/countriesapi/readme.md)

It contains the classes needed to interact with the RESTCountries API

## [<em>istatapi</em>](./src/main/java/its/statea/producer/istatapi/readme.md)

It contains the classes needed to interact with the Istat API

## [<em>kafka</em>](./src/main/java/its/statea/producer/kafka/readme.md)

It contains the classes that manage Kafka write operations

## [<em>message</em>](./src/main/java/its/statea/producer/message/readme.md)

It contains the entities needed for serialization of Kafka messages 

## [<em>redis</em>](./src/main/java/its/statea/producer/redis/readme.md)

It contains the classes that manage Redis read/write operations.

Redis is used to store the date of the last update.

## [<em>scheduledtasks</em>](./src/main/java/its/statea/producer/scheduledtasks/readme.md)

It contains the main Scheduled tasks of the application

## <em>resources</em>

It contains all the Spring Boot configurations:

- <strong>application-dev.properties:</strong> configurations during development
- <strong>application.properties:</strong> configurations during production