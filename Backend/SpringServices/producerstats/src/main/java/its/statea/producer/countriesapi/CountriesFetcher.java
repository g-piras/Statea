package its.statea.producer.countriesapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import its.statea.producer.countriesapi.entity.Country;

public class CountriesFetcher {

    private static ObjectMapper mapper = new ObjectMapper();
    
    public static Map<Country, Country> countriesFetch() throws URISyntaxException, IOException, InterruptedException, HttpException {

        HttpRequest req = HttpRequest.newBuilder()
                            .uri(
                                (new URIBuilder("https://restcountries.com/v3.1/all"))
                                .addParameter("fields", "name,cca2,translations").build()
                            )
                            .GET()
                            .header("Accept", "application/json")
                            .build();
        
        HttpResponse<InputStream> res = HttpClient
        .newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build()
        .send(req, BodyHandlers.ofInputStream());

        try (InputStream bodyStream = res.body()) {

            if (res.statusCode() != 200) {

                throw new HttpException("Request failed with status code: " + res.statusCode());
            }
    
            Iterator<JsonNode> countries = mapper.readTree(bodyStream).elements();

            // JSON parse into Map<Country, Country>
            Map<Country, Country> countriesMap = new HashMap<>();
            while (countries.hasNext()) {

                Country currentCountry = mapper.treeToValue(countries.next(), Country.class);
                countriesMap.put(currentCountry, currentCountry);
            }

            // add aggregates (WORLD, WRL_X_ITA)
            Country world = new Country("WORLD", "World", "Mondo", true);
            countriesMap.put(world, world);
            Country wrlXIta = new Country("WRL_X_ITA", "Foreign countries", "Paesi esteri", true);
            countriesMap.put(wrlXIta, wrlXIta);

            return countriesMap;
        }
    }
}
