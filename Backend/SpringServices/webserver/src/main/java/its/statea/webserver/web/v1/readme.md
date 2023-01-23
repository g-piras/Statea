# v1

Classes that define the web API version 1.

You can find more details about the API on [swagger](https://app.swaggerhub.com/apis/emilio.gasbarro/touristats/v1).

# Folder Structure

## <em>controller</em>

API Controllers

- <strong>RestControllerCommonV1:</strong> endpoints for data common to both ML forecasts and statistical data
- <strong>RestControllerDataV1:</strong> endpoints for statistical data
- <strong>RestControllerForecastsV1:</strong> endpoints for ML forecasts 

## <em>payload</em>

Entities that handle request and response parameters and body

 - [request](./payload/request/readme.md)
 - [response](./payload/response/readme.md)