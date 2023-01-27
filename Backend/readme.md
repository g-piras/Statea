# Backend

This is the root folder for the project's Back-End.

# Project Architecture

![architecture](./architecture.png)

# Database Schema

![DB schema](./schema.png)

# Configuration

>:warning: In order to work on the project you need to install [Docker](https://www.docker.com/) on your device.

Depending on the development stage and/or Server resources you can choose one of the following options:

## [1. <em>labintegrato_STATEA_dev</em>](./Setup/Docker_Setup/labintegrato_STATEA_dev/readme.md)

Docker setup for Back-End development

## [2. <em>labintegrato_STATEA</em>](./Setup/Docker_Setup/labintegrato_STATEA/readme.md)

Docker setup for Production deployment

## [3. <em>labintegrato_STATEA_lite</em>](./Setup/Docker_Setup/labintegrato_STATEA_lite/readme.md)

Docker Setup for Production deployment. Kafka queues and scheduled services have been removed in order to reduce memory footprint

# Contents

## [<em>architecture.png</em>](./architecture.png)

Project's architecture overview

## [<em>DBusers</em>](./DBusers.md)

List of DB users after importing [DB dump](./stateadb_dump.sql)

## [<em>schema.png</em>](./schema.png)

DB schema diagram

## [<em>stateadb_dump.sql</em>](./stateadb_dump.sql)

DB data and schema dump

## [<em>Setup</em>](./Setup/readme.md)

It contains all the files necessary for the initial setup of the Back-End

## [<em>SpringServices</em>](./SpringServices/readme.md)

It contains the source code for the main services of the Back-End