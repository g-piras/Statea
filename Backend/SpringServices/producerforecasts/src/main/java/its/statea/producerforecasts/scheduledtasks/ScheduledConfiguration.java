package its.statea.producerforecasts.scheduledtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskSchedulerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import its.statea.producerforecasts.kafka.KafkaService;

@Configuration
@EnableScheduling
public class ScheduledConfiguration implements TaskSchedulerCustomizer {

    private static final Logger log = LoggerFactory.getLogger(ScheduledConfiguration.class);

    @Autowired
    private KafkaService kafkaService;

    @Override
    public void customize(ThreadPoolTaskScheduler taskScheduler) {

        // This error handler will log the error and send a message to kafka signalling the scheduled check failed
        taskScheduler.setErrorHandler(ex -> {

            //LOG
            log.error("Error: ", ex);
            kafkaService.sendError(ex);
        });
    }
    
}
