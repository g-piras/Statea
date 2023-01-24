package its.statea.producer.istatapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import its.statea.producer.countriesapi.entity.Country;
import its.statea.producer.istatapi.entity.AccommodationType;
import its.statea.producer.istatapi.entity.District;
import its.statea.producer.istatapi.entity.IstatRecordAbstract;
import its.statea.producer.istatapi.entity.IstatRecordMonth;
import its.statea.producer.istatapi.entity.IstatRecordYear;
import its.statea.producer.istatapi.entity.ObservationType;
import its.statea.producer.kafka.KafkaService;
import its.statea.producer.message.IstatRecordMonthMessage;
import its.statea.producer.message.IstatRecordYearMessage;

@Service
public class IstatRecordService {

    @Autowired
    private KafkaService kafkaService;
    private ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    private <T extends IstatRecordAbstract> void filterAndSend( T currentRecord, 
                                    Map<Country, Country> originFilter,
                                    Map<District, District> destinationFilter, 
                                    Map<AccommodationType, AccommodationType> accommodationTypeFilter,
                                    Map<ObservationType, ObservationType> observationTypeFilter)
                                    throws IOException, InterruptedException, ExecutionException {

        // apply filters then check for blank observation values
        if (
            currentRecord != null
            &&
            originFilter.containsKey(currentRecord.getOrigin())
            &&
            destinationFilter.containsKey(currentRecord.getDestination())
            &&
            accommodationTypeFilter.containsKey(currentRecord.getAccommodationType())
            &&
            observationTypeFilter.containsKey(currentRecord.getObservationType())
            &&
            currentRecord.hasValidValue()
        ) {

            // add missing information to currentRecord
            currentRecord.setOrigin(originFilter.get(currentRecord.getOrigin()));
            currentRecord.setDestination(destinationFilter.get(currentRecord.getDestination()));
            currentRecord.setAccommodationType(accommodationTypeFilter.get(currentRecord.getAccommodationType()));
            currentRecord.setObservationType(observationTypeFilter.get(currentRecord.getObservationType()));

            /** !!!!!!!!!!!!!!!!!!!! Better approach but unfortunately Java Generics are not suited for De/Serialization !!!!!!!!!!!!!!!!!!!!
             * 
             * kafkaService.sendMessage(new IstatRecordMessage<T>(currentRecord));
             */

            if (currentRecord instanceof IstatRecordMonth) {

                kafkaService.sendMessage(new IstatRecordMonthMessage((IstatRecordMonth)currentRecord));
            }
            else if (currentRecord instanceof IstatRecordYear) {

                kafkaService.sendMessage(new IstatRecordYearMessage((IstatRecordYear)currentRecord));
            }
        }
    }

    public void parseFilterAndSend( InputStream dataStream, 
                                    Map<Country, Country> originFilter,
                                    Map<District, District> destinationFilter, 
                                    Map<AccommodationType, AccommodationType> accommodationTypeFilter,
                                    Map<ObservationType, ObservationType> observationTypeFilter)
                                    throws IOException, InterruptedException, ExecutionException {

        try (BufferedReader dataReader = new BufferedReader(new InputStreamReader(dataStream))) {

            CSVParser parser = CSVParser.parse(dataReader,
                    CSVFormat.DEFAULT.builder()
                                    .setHeader()
                                    .setSkipHeaderRecord(true)
                                    .setAllowMissingColumnNames(false)
                                    .build());
            for (CSVRecord csvRecord : parser) {

                // different serialization based on frequency column
                // NOTE: it throws an exception if column not present
                if (csvRecord.get("FREQ").equals("A")) {

                    IstatRecordYear currentRecord = mapper.readValue(mapper.writeValueAsString(csvRecord.toMap()), IstatRecordYear.class);
                    filterAndSend(currentRecord, originFilter, destinationFilter, accommodationTypeFilter, observationTypeFilter);
                }
                else if (csvRecord.get("FREQ").equals("M")) {

                    IstatRecordMonth currentRecord = mapper.readValue(mapper.writeValueAsString(csvRecord.toMap()), IstatRecordMonth.class);
                    filterAndSend(currentRecord, originFilter, destinationFilter, accommodationTypeFilter, observationTypeFilter);
                }
            }
        }
    }

    public InputStream istatRecordsFetch(String isoDate) throws URISyntaxException, IOException, InterruptedException, HttpException {

        return DataFetcher.istatRecordsFetch(isoDate);
    }
}