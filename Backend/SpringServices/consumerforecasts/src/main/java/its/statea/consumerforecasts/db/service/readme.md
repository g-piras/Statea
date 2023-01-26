# Service

This folder contains all the services that expose DB operations to Spring Components.

They also manage transactions.

# Folder Structure

## <em>root</em>

Main DB services

- <strong>AccommodationTypeService:</strong> base read operations
- <strong>DestinationService:</strong> base read operations
- <strong>ObservationTypeService:</strong> base read operations
- <strong>OriginService:</strong> base read operations
- <strong>PredictionMonthService:</strong> read and write operations [^1]
- <strong>PredictionYearService:</strong> read and write operations [^1]

[^1]: write operations are idempotent