# ConsumerTasks

This folder contains the main Kafka Listeners that manage message consumption.

# Folder Structure

## <em>root</em>

Kafka Listeners

- <strong>ConsumerTasks:</strong> it dispatches any message from <em>forecastsTopic</em> to the appropriate KafkaHandler based on message type.
It also handles errors by sending a message to the dedicated Kafka topic.