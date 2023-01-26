# ScheduledTasks

This folder contains the classes that manage the main scheduled tasks of the application.

# Folder Structure

## <em>root</em>

Kafka Scheduled Services

- <strong>ScheduledConfiguration:</strong> Scheduler configurations.
The configured error handler will send a message to the dedicated Kafka topic.
- <strong>ScheduledTasks:</strong> Spring Service that performs the main application activities on a schedule set with a <em>cron expression</em>.