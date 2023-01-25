# SpringServices

This folder contains the source code for the main services of the Back-End

# Contents

## [<em>consumerforecasts</em>](./consumerforecasts/readme.md)

Spring Service that reads prediction records from a Kafka queue and stores them inside a SQL Database (MariaDB).

## [<em>consumerstats</em>](./consumerstats/readme.md)

Spring Service that reads statistical records from a Kafka queue and stores them inside a SQL Database (MariaDB).

## [<em>producerforecasts</em>](./producerforecasts/readme.md)

Spring Service that fetches forecast data from the dedicated Fintech service on a scheduled basis and sends the records to a Kafka topic.

## [<em>producerstats</em>](./producerstats/readme.md)

Spring Service that fetches new data from the Istat API on a scheduled basis and sends the records found to a Kafka topic.

## [<em>webserver</em>](./webserver/readme.md)

Spring Service that exposes DB data through a REST API.