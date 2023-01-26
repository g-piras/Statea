package its.statea.producer.kafka;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import its.statea.producer.message.ErrorMessage;
import its.statea.producer.message.MyMessage;

@Service
public class KafkaService {

    private static final Logger log = LoggerFactory.getLogger(KafkaService.class);
    
    private static final String mainTopic = "statsTopic";
    private static final String errorTopic = "errorTopic";

    @Autowired
    private KafkaTemplate<String, MyMessage> kafkaTemplate;

    public void sendMessage(MyMessage message) throws InterruptedException, ExecutionException {

        // get() makes it synchronous
        this.kafkaTemplate.send(mainTopic, message).get();

        //LOG
        log.info("Message sent -> {}", message);
    }

    public void sendError(Throwable ex) {

        this.kafkaTemplate.send(errorTopic, new ErrorMessage("Critical Error " + ex.getMessage())); 
    }
}
