# labintegrato_STATEA_lite

Docker Setup for Production deployment. 

Kafka queues and scheduled services have been removed in order to reduce memory footprint.

# How to deploy
Firstly:

1) Generate the .jar files for [webserver](../../../SpringServices/webserver/readme.md)
2) Copy the .jar file in the corresponding folder

When the .jar file is in place:

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

# Contents

## <em>frontend</em>

Dockerfile and source code for the NextJS frontend

## <em>webserver</em>

Dockerfile and JAR package for Web API service

## <em>compose.yml</em>

Docker compose configuration