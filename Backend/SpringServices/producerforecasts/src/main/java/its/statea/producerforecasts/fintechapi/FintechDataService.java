package its.statea.producerforecasts.fintechapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import its.statea.producerforecasts.fintechapi.entity.FintechRecordAbstract;
import its.statea.producerforecasts.fintechapi.entity.FintechRecordMonth;
import its.statea.producerforecasts.fintechapi.entity.FintechRecordYear;
import its.statea.producerforecasts.fintechapi.entity.request.FintechDataRequest;
import its.statea.producerforecasts.fintechapi.entity.request.ResourceListTypesEnum;
import its.statea.producerforecasts.message.FintechRecordMonthMessage;
import its.statea.producerforecasts.message.FintechRecordYearMessage;

@Service
public class FintechDataService {

    @Autowired
    private its.statea.producerforecasts.kafka.KafkaService kafkaService;
    private ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    public <T extends FintechRecordAbstract> void parseRecordsAndSend(InputStream dataStream, Class<T> classType) throws IOException, InterruptedException, ExecutionException {

        try (BufferedReader dataReader = new BufferedReader(new InputStreamReader(dataStream))) {

            Iterator<JsonNode> records = mapper.readTree(dataReader).elements();

            while (records.hasNext()) {

                T currentRecord = mapper.treeToValue(records.next(), classType);

                            /** !!!!!!!!!!!!!!!!!!!! Better approach but unfortunately Java Generics are not suited for De/Serialization !!!!!!!!!!!!!!!!!!!!
                 * 
                 * kafkaService.sendMessage(new FintechRecordMessage<T>(currentRecord));
                 */

                if (currentRecord instanceof FintechRecordMonth) {

                    kafkaService.sendMessage(new FintechRecordMonthMessage((FintechRecordMonth)currentRecord));
                }
                else if (currentRecord instanceof FintechRecordYear) {

                    kafkaService.sendMessage(new FintechRecordYearMessage((FintechRecordYear)currentRecord));
                }
            }
        }
    }

    public void parseResourceListAndSend(InputStream dataStream, ResourceListTypesEnum resourceType) throws IOException, JsonProcessingException, URISyntaxException, InterruptedException, HttpException, ExecutionException {

        try (BufferedReader dataReader = new BufferedReader(new InputStreamReader(dataStream))){

            Iterator<JsonNode> resources = mapper.readTree(dataReader).elements();

            while (resources.hasNext()) {

                // extract resource name
                String currentResource = mapper.treeToValue(resources.next(), String.class);

                // build request body
                String requestBody = mapper
                                    .writerWithDefaultPrettyPrinter()
                                    .writeValueAsString(new FintechDataRequest(currentResource, resourceType.getQuantity()));

                // make the call to obtain the forecast records
                InputStream recordsStream = FintechDataManager.fintechRecordsFetch(requestBody);

                // parse records and send them to Kafka topic
                parseRecordsAndSend(recordsStream, resourceType.getRecordType());

                recordsStream.close();
            }
        }
    }

    public InputStream fintechResourceListFetch(ResourceListTypesEnum resourceType) throws URISyntaxException, IOException, InterruptedException, HttpException {

        return FintechDataManager.fintechResourceListFetch(resourceType);
    }

    public void fintechModelUpdate() throws URISyntaxException, IOException, InterruptedException, HttpException {

        FintechDataManager.fintechModelUpdate();
    }
}