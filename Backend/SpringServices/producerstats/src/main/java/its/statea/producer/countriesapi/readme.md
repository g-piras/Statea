# CountriesAPI

This folder contains the classes needed to interact with the RESTCountries API

# Folder Structure

## <em>root</em>

It contains classes for data retrieval and parsing

 - <strong>CountriesFetcher:</strong> static class containing methods for fetching countries and building a filter for later use. [^1]

## <em>entity</em>

RESTCountries API entities

- <strong>Country:</strong> country POJO annotated for deserialization describing travel origins (Italy, France, World) [^2]

[^1]: the filter's type is a Map for O(1) data retrieval time complexity
[^2]: <em>aggregate</em> determines whether it is a Country (false) or a Group of countries (true) 