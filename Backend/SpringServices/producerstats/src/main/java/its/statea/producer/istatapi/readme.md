# IstatAPI

This folder contains the classes needed to interact with the Istat API

# Folder Structure

## <em>root</em>

It contains classes for data retrieval and parsing

 - <strong>DataFetcher:</strong> static class containing utility methods for fetching Istat data as InputStream
 - <strong>DistrictService:</strong> Spring Service for fetching and parsing Districts of Sardinia, building a filter for later use [^1]
 - <strong>IstatRecordService:</strong> Spring Service for fetching, filtering, parsing and sending Istat records to Kafka topic

## <em>entity</em>

Istat API entities

- <strong>AccommodationType:</strong> entity for types of accommodation (HOTELLIKE, OTHER)
- <strong>District:</strong> entity for travel destinations (Cagliari, Sardegna) [^2]
- <strong>IstatRecordAbstract:</strong> base class for Istat records
- <strong>IstatRecordMonth:</strong> entity for Istat data (monthly observations)
- <strong>IstatRecordYear:</strong> entity for Istat data (annual observations)
- <strong>ObservationType:</strong> entity for types of observation (Arrivals, Nights)

[^1]: the filter's type is a Map for O(1) data retrieval time complexity
[^2]: <em>aggregate</em> determines whether it is a District (false) or the whole Region (true) 