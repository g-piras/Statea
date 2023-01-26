package its.statea.consumer.queue.consumertasks;

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

import its.statea.consumer.db.entity.AccommodationType;
import its.statea.consumer.db.entity.Destination;
import its.statea.consumer.db.entity.ObservationMonth;
import its.statea.consumer.db.entity.ObservationType;
import its.statea.consumer.db.entity.ObservationYear;
import its.statea.consumer.db.entity.Origin;
import its.statea.consumer.db.service.ObservationMonthService;
import its.statea.consumer.db.service.ObservationYearService;
import its.statea.consumer.queue.istatapi.entity.IstatRecordMonth;
import its.statea.consumer.queue.istatapi.entity.IstatRecordYear;
import its.statea.consumer.queue.kafka.KafkaService;
import its.statea.consumer.queue.message.IstatRecordMonthMessage;
import its.statea.consumer.queue.message.IstatRecordYearMessage;

@Service
@KafkaListener(topics = "statsTopic", batch = "false")
public class ConsumerTasks {
    
    private static final Logger log = LoggerFactory.getLogger(ConsumerTasks.class);

    private static final long timeInterval = 1000L;
    private static final long maxAttempts = 29L;

    @Autowired
    private KafkaService kafkaService;
    @Autowired
    private ObservationMonthService observationMonthService;
    @Autowired
    private ObservationYearService observationYearService;

    @KafkaHandler
    public void consumeMessage(IstatRecordMonthMessage message) {

        // DEBUG
        log.info("Message consumed -> {}", message);
        
        IstatRecordMonth currentRecord = message.getRecord();

        // build Observation Month record
        ObservationMonth currentObservation = new ObservationMonth(
            new Origin(currentRecord.getOrigin().getCountryCode(), currentRecord.getOrigin().getNameIta(), currentRecord.getOrigin().getNameEng(), currentRecord.getOrigin().isAggregate()),
            new Destination(currentRecord.getDestination().getId(), currentRecord.getDestination().getName(), currentRecord.getDestination().isAggregate()), 
            new AccommodationType(currentRecord.getAccommodationType().getId(), currentRecord.getAccommodationType().getName()), 
            new ObservationType(currentRecord.getObservationType().getId(), currentRecord.getObservationType().getName()), 
            Date.valueOf(currentRecord.getDate()), 
            Long.parseLong(currentRecord.getObservation())
        );
        
        // insert or update Observation Month record
        observationMonthService.saveRecord(currentObservation);       
    }

    @KafkaHandler
    public void consumeMessage(IstatRecordYearMessage message) {

        // DEBUG
        log.info("Message consumed -> {}", message);
        
        IstatRecordYear currentRecord = message.getRecord();

        // build Observation Year record
        ObservationYear currentObservation = new ObservationYear(
            new Origin(currentRecord.getOrigin().getCountryCode(), currentRecord.getOrigin().getNameIta(), currentRecord.getOrigin().getNameEng(), currentRecord.getOrigin().isAggregate()),
            new Destination(currentRecord.getDestination().getId(), currentRecord.getDestination().getName(), currentRecord.getDestination().isAggregate()), 
            new AccommodationType(currentRecord.getAccommodationType().getId(), currentRecord.getAccommodationType().getName()), 
            new ObservationType(currentRecord.getObservationType().getId(), currentRecord.getObservationType().getName()), 
            currentRecord.getYear(), 
            Long.parseLong(currentRecord.getObservation())
        );
        
        // insert or update Observation Year record
        observationYearService.saveRecord(currentObservation);        
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
            throw new RuntimeException(); // this will force the KafkaListener to process the same message again

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
