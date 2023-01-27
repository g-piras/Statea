# labintegrato_STATEA

Docker setup for Production deployment

# How to deploy
Firstly:

1) Generate the .jar files for [consumerforecasts](../../../SpringServices/consumerforecasts/readme.md), [consumerstats](../../../SpringServices/consumerstats/readme.md), [producerforecasts](../../../SpringServices/producerforecasts/readme.md), [producerstats](../../../SpringServices/producerstats/readme.md), [webserver](../../../SpringServices/webserver/readme.md)
2) Copy the .jar files in the corresponding folders

When the .jar files are in place:

3) Execute `docker compose build` to build the Docker images
4) Execute `docker compose -p statea up -d` to run Docker

Only the first time:

5) Go to `localhost:9981`
6) Log into phpMyAdmin with user `root` and password `test`
7) Import the [DB dump](../../../stateadb_dump.sql)

Finally:

8) Go to `localhost:9930` to access the website
        
Notes:

 - PhpMyAdmin: `localhost:9981`
 - Webserver: `0.0.0.0:9980`
 - Frontend: `0.0.0.0:9930`

# Warning

Docker volumes `statea_kafka-data` and `statea_zookeeper-data` work in pair.
Hence you either delete both or none of them.

# Contents

## <em>consumerforecasts</em>

Dockerfile, JAR package and Kafka keys for Consumer Forecasts service

## <em>consumerstats</em>

Dockerfile, JAR package and Kafka keys for Consumer Stats service

## <em>fintech</em>

Dockerfile and source code for the FinTech service

## <em>frontend</em>

Dockerfile and source code for the NextJS frontend

## <em>kafka</em>

Dockerfile and Kafka keys for Kafka service

## <em>myredis</em>

Dockerfile and configuration for Redis service.

Redis is mainly used to store the date of the last update of the statistical data.

## <em>producerforecasts</em>

Dockerfile, JAR package and Kafka keys for Producer Forecasts service

## <em>producerstats</em>

Dockerfile, JAR package and Kafka keys for Producer Stats service

## <em>webserver</em>

Dockerfile and JAR package for Web API service

## <em>compose.yml</em>

Docker compose configuration