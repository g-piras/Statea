# FintechAPI

This folder contains the classes needed to interact with the FinTech API

# Folder Structure

## <em>root</em>

It contains classes for model generation, data retrieval and parsing

 - <strong>FintechDataManager:</strong> static package private class containing utility methods for fetching data and generating ML models
 - <strong>FintechDataService:</strong> Spring Service that exposes the main operations of FinTech API. It also handles the parsing and sending of records to Kafka topic

## <em>entity</em>

Fintech API entities

- <strong>FintechRecordAbstract:</strong> base class for Fintech records
- <strong>FintechRecordMonth:</strong> entity for Fintech data (monthly forecasts)
- <strong>FintechRecordYear:</strong> entity for Fintech data (annual forecasts)
- <strong>[request](./entity/request/readme.md):</strong> classes and enums for API requests