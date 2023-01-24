package its.statea.producer.istatapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import its.statea.producer.istatapi.entity.District;

@Service
public class DistrictService {

    private ObjectMapper mapper = new ObjectMapper();
    
    /**
     * 
     * @param dataStream
     * @return 
     * @note The method returns a Map instead of a Set for data retrieval in O(1) time complexity (Set has no get() method in Java)
     * @throws IOException
     */
    public Map<District, District> parse(InputStream dataStream) throws IOException {

        try (BufferedReader dataReader = new BufferedReader(new InputStreamReader(dataStream))) {

            JsonNode node = mapper.readTree(dataReader);

            // setting up lookup
            Map<District, District> validDistricts = new HashMap<>();

            // JSON tree traversal to find available Sardinian districts
            Iterator<JsonNode> dimensions = node.get("data").get("structure").get("dimensions").get("series").elements();
            while (dimensions.hasNext()) {

                JsonNode dimension = dimensions.next();

                if (dimension.get("id").asText().equals("ITTER107")) {

                    Iterator<JsonNode> districts = dimension.get("values").elements();
                    while (districts.hasNext()) {

                        JsonNode district = districts.next();

                        String currentId = district.get("id").asText();
                        // Sardinian districts start with "ITG2". "IT111" represents the new "Sud Sardegna" district
                        if (currentId.startsWith("ITG2") || currentId.equals("IT111")) {

                            // add Sardinian district to Map
                            District currentDistrict = mapper.treeToValue(district, District.class);
                            validDistricts.put(currentDistrict, currentDistrict);
                        }
                    }

                    // set Sardinia as aggregate record
                    District sardinia = validDistricts.remove(new District("ITG2", null, false));
                    sardinia.setAggregate(true);
                    validDistricts.put(sardinia, sardinia);
                }
            }

            dataReader.close();
            return validDistricts;
        }
    }

    public InputStream districtInfoFetch() throws URISyntaxException, IOException, InterruptedException, HttpException {

        return DataFetcher.districtInfoFetch();
    }
}