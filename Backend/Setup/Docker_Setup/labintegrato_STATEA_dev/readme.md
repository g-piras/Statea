# labintegrato_STATEA_dev

Docker setup for Back-End development

# How to deploy

Firstly:

1) Execute `docker build -t stateadev/myubuntu ./myubuntu` to build MyUbuntu image
2) Execute `docker compose -p stateadev up -d` to run Docker

Only the first time:

3) Go to `localhost:9983`
4) Log into phpMyAdmin with user `root` and password `test`
5) Import the [DB dump](../../../stateadb_dump.sql)

Finally:

6) Access a container with VSCode ([guide here](https://code.visualstudio.com/docs/devcontainers/containers)) and execute the command `cd /home/spring` inside the container
7) Clone the repository with the `git clone` command
8) Move to the [service folder](../../../SpringServices) for the specific container with the `cd` command
9) If necessary install the following VSCode extensions: [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) and [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=pivotal.vscode-boot-dev-pack)
10) Run the Spring service 

Notes:

 - PhpMyAdmin: `localhost:9983`
 - Webserver: `localhost:9982`
 - MariaDB: `localhost:9906`
 - FinTech: `localhost:9950`

# Warning

Docker volumes `stateadev_kafka-data` and `stateadev_zookeeper-data` work in pair.
Hence you either delete both or none of them.

# Contents

## <em>fintech</em>

Dockerfile and source code for the FinTech service

## <em>kafka</em>

Dockerfile and Kafka keys for Kafka service

## <em>myredis</em>

Dockerfile and configuration for Redis service.

Redis is mainly used to store the date of the last update of the statistical data.

## <em>myubuntu</em>

Dockerfile for MyUbuntu image

## <em>newcerts</em>

Backup of all keys and certificates for Kafka SSL authentication

## <em>ubuntu_consumerforecasts</em>

Dockerfile and Kafka keys for Consumer Forecasts service

## <em>ubuntu_consumerstats</em>

Dockerfile and Kafka keys for Consumer Stats service

## <em>ubuntu_producerforecasts</em>

Dockerfile and Kafka keys for Producer Forecasts service

## <em>ubuntu_producerstats</em>

Dockerfile and Kafka keys for Producer Stats service

## <em>webserver</em>

Dockerfile and Apache configuration for Web API service

## <em>compose.yml</em>

Docker compose configuration