# Entity

This folder contains all the entities that model the Database.

# Folder Structure

## <em>root</em>

Main DB entities.

- <strong>AccommodationType:</strong> entity to store types of accommodation (HOTELLIKE, OTHER)
- <strong>Destination:</strong> entity to store travel destinations (Cagliari, Sardegna) [^1] 
- <strong>ObservationMonth:</strong> entity to store observations (monthly data)
- <strong>ObservationType:</strong> entity to store types of observation (Arrivals, Nights)
- <strong>ObservationYear:</strong> entity to store observations (annual data)
- <strong>Origin:</strong> entity to store travel origins (Italy, France, World) [^2]

[^1]: <em>isAggregate</em> determines whether it is a District (false) or the whole Region (true) 

[^2]: <em>isAggregate</em> determines whether it is a Country (false) or a Group of countries (true) 

## <em>abstractentity</em>

It contains secondary entities used for class extension and inheritance.
They do not have a direct table correspondence inside the DB schema.

 - <strong>ObservationAbstract:</strong> base class for Observation records

## <em>composite</em>

It contains all the classes that represent composite Primary Keys for other entities.

- <strong>ObservationMonthKey:</strong> PK for ObservationMonth
- <strong>ObservationYearKey:</strong> PK for ObservationYear