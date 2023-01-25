package its.statea.consumerforecasts.queue.consumertasks;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.backoff.FixedBackOff;

import its.statea.consumerforecasts.db.entity.AccommodationType;
import its.statea.consumerforecasts.db.entity.Destination;
import its.statea.consumerforecasts.db.entity.ObservationType;
import its.statea.consumerforecasts.db.entity.Origin;
import its.statea.consumerforecasts.db.entity.PredictionMonth;
import its.statea.consumerforecasts.db.entity.PredictionYear;
import its.statea.consumerforecasts.db.service.PredictionMonthService;
import its.statea.consumerforecasts.db.service.PredictionYearService;
import its.statea.consumerforecasts.queue.fintechapi.entity.FintechRecordMonth;
import its.statea.consumerforecasts.queue.fintechapi.entity.FintechRecordYear;
import its.statea.consumerforecasts.queue.kafka.KafkaService;
import its.statea.consumerforecasts.queue.message.FintechRecordMonthMessage;
import its.statea.consumerforecasts.queue.message.FintechRecordYearMessage;

@Service
@KafkaListener(topics = "forecastsTopic", batch = "false")
public class ConsumerTasks {
    
    private static final Logger log = LoggerFactory.getLogger(ConsumerTasks.class);

    private static final long timeInterval = 1000L;
    private static final long maxAttempts = 29L;

    @Autowired
    private KafkaService kafkaService;
    @Autowired
    private PredictionMonthService predictionMonthService;
    @Autowired
    private PredictionYearService predictionYearService;

    @KafkaHandler
    public void consumeMessage(FintechRecordMonthMessage message) {

        // DEBUG
        log.info("Message consumed -> {}", message);
        
        FintechRecordMonth currentRecord = message.getRecord();

        // build Prediction Month record
        PredictionMonth currentPrediction = new PredictionMonth(
            new Origin(currentRecord.getOrigin()),
            new Destination(currentRecord.getDestination()), 
            new AccommodationType(currentRecord.getTypeHotel()), 
            new ObservationType(currentRecord.getType()), 
            Date.valueOf(currentRecord.getDate()), 
            Long.parseLong(currentRecord.getValue())
        );
        
        // insert or update Prediction Month record
        predictionMonthService.saveRecord(currentPrediction);       
    }

    @KafkaHandler
    public void consumeMessage(FintechRecordYearMessage message) {

        // DEBUG
        log.info("Message consumed -> {}", message);
        
        FintechRecordYear currentRecord = message.getRecord();

        // build Prediction Year record
        PredictionYear currentPrediction = new PredictionYear(
            new Origin(currentRecord.getOrigin()),
            new Destination(currentRecord.getDestination()), 
            new AccommodationType(currentRecord.getTypeHotel()), 
            new ObservationType(currentRecord.getType()), 
            currentRecord.getYear(), 
            Long.parseLong(currentRecord.getValue())
        );
        
        // insert or update Prediction Year record
        predictionYearService.saveRecord(currentPrediction);        
    }

    @KafkaHandler(isDefault = true)
    public void consumeMessage(Object object) {

        // DEBUG
        log.error("You're not supposed to be here!");   
    }

    @Bean
    private DefaultErrorHandler myErrorHandler() {

        // infinite loop on the specific message in case of error
        return new DefaultErrorHandler((record, ex) -> {

            // DEBUG
            log.error("Error: ", ex);

            criticalError(ex);
            throw new RuntimeException();

        }, new FixedBackOff(timeInterval, maxAttempts));
    }

    /**
     * This method will send a message to kafka signalling the operation failed
     * @param ex
     */
    public void criticalError(Exception ex) {

        kafkaService.sendError(ex);
    }
}
