# Entity

This folder contains all the entities that model the Database.

# Folder Structure

## <em>root</em>

Main DB entities

- <strong>AccommodationType:</strong> entity to store types of accommodation (HOTELLIKE, OTHER)
- <strong>Destination:</strong> entity to store travel destinations (Cagliari, Sardegna) [^1] 
- <strong>ObservationType:</strong> entity to store types of observation (Arrivals, Nights)
- <strong>Origin:</strong> entity to store travel origins (Italy, France, World) [^2]
- <strong>PredictionMonth:</strong> entity to store forecasts (monthly data)
- <strong>PredictionYear:</strong> entity to store forecasts (annual data)

[^1]: <em>isAggregate</em> determines whether it is a District (false) or the whole Region (true) 

[^2]: <em>isAggregate</em> determines whether it is a Country (false) or a Group of countries (true) 

## <em>abstractentity</em>

It contains secondary entities used for class extension and inheritance.
They do not have a direct table correspondence inside the DB schema.

 - <strong>PredictionAbstract:</strong> base class for Prediction records

## <em>composite</em>

It contains all the classes that represent composite Primary Keys for other entities.

- <strong>PredictionMonthKey:</strong> PK for PredictionMonth
- <strong>PredictionYearKey:</strong> PK for PredictionYear