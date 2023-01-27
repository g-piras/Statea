# Entity

This folder contains all the entities that model the Database.

# Folder Structure

## <em>root</em>

Main DB entities. [^1]

- <strong>AccommodationType:</strong> entity to store types of accommodation (HOTELLIKE, OTHER)
- <strong>Destination:</strong> entity to store travel destinations (Cagliari, Sardegna) [^2] 
- <strong>ObservationMonthCustomView:</strong> entity to store observations (monthly data) [^3]
- <strong>ObservationType:</strong> entity to store types of observation (Arrivals, Nights)
- <strong>ObservationYear:</strong> entity to store observations (annual data)
- <strong>Origin:</strong> entity to store travel origins (Italy, France, World) [^4]
- <strong>PredictionMonth:</strong> entity to store forecasts (monthly data)
- <strong>PredictionYear:</strong> entity to store forecasts (annual data)

[^1]: they all implement one of the Datamap interfaces

[^2]: <em>isAggregate</em> determines whether it is a District (false) or the whole Region (true) 

[^3]: it is actually a view whose purpose is to normalize Istat data. Instead of relying on stored data, `WORLD` records are computed in order to move up the start date from `2016-01-01` to `2008-01-01`

[^4]: <em>isAggregate</em> determines whether it is a Country (false) or a Group of countries (true) 

## <em>abstractentity</em>

It contains secondary entities used for class extension and inheritance.
They do not have a direct table correspondence inside the DB schema.

 - <strong>ObservationAbstract:</strong> base class for Observation records
 - <strong>PredictionAbstract:</strong> base class for Prediction records

## <em>composite</em>

It contains all the classes that represent composite Primary Keys for other entities.

- <strong>ObservationMonthKey:</strong> PK for ObservationMonthCustomView
- <strong>ObservationYearKey:</strong> PK for ObservationYear
- <strong>PredictionMonthKey:</strong> PK for PredictionMonth
- <strong>PredictionYearKey:</strong> PK for PredictionYear