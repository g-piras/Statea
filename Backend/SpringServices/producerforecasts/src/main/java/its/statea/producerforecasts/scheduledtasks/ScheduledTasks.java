package its.statea.producerforecasts.scheduledtasks;

import java.io.InputStream;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import its.statea.producerforecasts.fintechapi.FintechDataService;
import its.statea.producerforecasts.fintechapi.entity.request.ResourceListTypesEnum;

@Service
public class ScheduledTasks {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private FintechDataService fintechDataService;
    
    // @Scheduled(fixedDelay = 1000000)
    @Scheduled(cron = "00 01 01 * * FRI", zone = "Europe/Rome") // Weekly on Friday night
    public void reportCurrentTime() throws Exception {

        //LOG
        log.info("Started at: {}", LocalDateTime.now());

        // update ML model
        fintechDataService.fintechModelUpdate();

        // fetch monthly resources list
        try (InputStream monthlyList = fintechDataService.fintechResourceListFetch(ResourceListTypesEnum.monthly)){

            // parse and send records
            fintechDataService.parseResourceListAndSend(monthlyList, ResourceListTypesEnum.monthly);
        }

        // fetch annual resources list
        try (InputStream annualList = fintechDataService.fintechResourceListFetch(ResourceListTypesEnum.annual)) {

            // parse and send records
            fintechDataService.parseResourceListAndSend(annualList, ResourceListTypesEnum.annual);
        }

        //LOG
        log.info("Success at: {}", LocalDateTime.now());
    }
}