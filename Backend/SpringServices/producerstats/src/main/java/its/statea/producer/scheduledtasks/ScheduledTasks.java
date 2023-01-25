package its.statea.producer.scheduledtasks;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import its.statea.producer.countriesapi.CountriesFetcher;
import its.statea.producer.countriesapi.entity.Country;
import its.statea.producer.istatapi.DistrictService;
import its.statea.producer.istatapi.IstatRecordService;
import its.statea.producer.istatapi.entity.AccommodationType;
import its.statea.producer.istatapi.entity.District;
import its.statea.producer.istatapi.entity.ObservationType;
import its.statea.producer.redis.RedisService;

@Service
public class ScheduledTasks {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private IstatRecordService istatRecordService;
    @Autowired
    private DistrictService districtService;

    // @Scheduled(fixedDelay = 1000000)
    @Scheduled(cron = "00 01 01 * * THU", zone = "Europe/Rome") // Weekly on Thursday night
    public void reportCurrentTime() throws Exception {

        //LOG
        log.info("Started at: {}", LocalDateTime.now());

        // setting up filters
        Map<Country, Country> originFilter = CountriesFetcher.countriesFetch();
        Map<District, District> destinationFilter = districtService.parse(districtService.districtInfoFetch());
        Map<AccommodationType, AccommodationType> accommodationTypeFilter = Map.ofEntries(
                                                                            Map.entry(new AccommodationType("ALL", "Total collective accommodation establishments"), new AccommodationType("ALL", "Total collective accommodation establishments")),
                                                                            Map.entry(new AccommodationType("OTHER", "Other collective accommodation establishments"), new AccommodationType("OTHER", "Other collective accommodation establishments")),
                                                                            Map.entry(new AccommodationType("HOTELLIKE", "Hotels and similar establishments"), new AccommodationType("HOTELLIKE", "Hotels and similar establishments"))
                                                                        );
        Map<ObservationType, ObservationType> observationTypeFilter = Map.ofEntries(
                                                                            Map.entry(new ObservationType("AR", "Arrivals"), new ObservationType("AR", "Arrivals")),
                                                                            Map.entry(new ObservationType("NI", "Nights spent"), new ObservationType("NI", "Nights spent"))
                                                                    );

        // get last update date from redis
        String lastUpdateDate = redisService.lastUpdateDate();

        // filter and send all relevant Istat records to Kafka statsTopic
        try (InputStream dataStream = istatRecordService.istatRecordsFetch(lastUpdateDate)) {
            
            istatRecordService.parseFilterAndSend(dataStream, originFilter, destinationFilter, accommodationTypeFilter, observationTypeFilter);
        }

        // update redis isoDate if all went well
        redisService.saveUpdateDate();

        //LOG
        log.info("Success at: {}", LocalDateTime.now());
    }
}