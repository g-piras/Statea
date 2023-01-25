# Restful API

Using [Flask](https://flask.palletsprojects.com/en/2.2.x/) to build a Restful API.

per ottimizzare l'api abbiamo deciso di suddividere le macro funzioni in due, main e load.

## Main

Il file main si occupa di prendere elaborare i dati dal get_all nei contoller e generare tutti gli script di predizione.

## Load

Gestische le richieste che vengono fatte agli script/funzioni e le sistema per poi essere utilizzate nel API.

## FLASK_API

Gestische le chiamate api predendo i dati già sistemati dal load.py

---

Swagger documentation:
[documentation](https://app.swaggerhub.com/apis/Kindaglia/Statea_Fintech/1.0.0)
