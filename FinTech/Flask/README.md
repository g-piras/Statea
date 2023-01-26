# Restful API

Using [Flask](https://flask.palletsprojects.com/en/2.2.x/) to build a Restful API.

to optimize the api we decided to split the macro functions into two, main and load.

## Main

The main file takes care of taking process the data from the get_all in the contollers and generate all the prediction scripts.

## Load

Handles the requests that are made to the scripts/functions and arranges them for later use in the API.

## FLASK_API.

Handles the api calls by predicting the data already arranged by load.py

---

Swagger documentation:
[documentation](https://app.swaggerhub.com/apis/Kindaglia/Statea_Fintech/1.0.0)
