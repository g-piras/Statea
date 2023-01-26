package its.statea.producerforecasts.fintechapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.http.HttpException;
import org.apache.http.client.utils.URIBuilder;

import its.statea.producerforecasts.fintechapi.entity.request.ResourceListTypesEnum;

class FintechDataManager {

    private static final String BASE_URL = "http://fintech:5000";

    static InputStream fintechRecordsFetch(String requestBody) throws URISyntaxException, IOException, InterruptedException, HttpException {

        HttpRequest req = HttpRequest.newBuilder()
                            .uri(
                                (new URIBuilder(BASE_URL)).setPath("prediction").build()
                            )
                            .POST(BodyPublishers.ofString(requestBody))
                            .header("Accept", "application/json") // JSON
                            .header("Content-Type", "application/json") // JSON
                            .build();
        
        HttpResponse<InputStream> res = HttpClient
        .newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build()
        .send(req, BodyHandlers.ofInputStream());

        if (res.statusCode() != 200) {

            res.body().close();
            throw new HttpException("Request failed with status code: " + res.statusCode());
        }

        return res.body();
    }

    static InputStream fintechResourceListFetch(ResourceListTypesEnum resourceType) throws URISyntaxException, IOException, InterruptedException, HttpException {

        HttpRequest req = HttpRequest.newBuilder()
                            .uri(
                                (new URIBuilder(BASE_URL)).setPath(resourceType.getPath()).build()
                            )
                            .GET()
                            .header("Accept", "application/json") // JSON
                            .build();
        
        HttpResponse<InputStream> res = HttpClient
        .newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build()
        .send(req, BodyHandlers.ofInputStream());

        if (res.statusCode() != 200) {

            res.body().close();
            throw new HttpException("Request failed with status code: " + res.statusCode());
        }

        return res.body();
    }

    static void fintechModelUpdate() throws URISyntaxException, IOException, InterruptedException, HttpException {

        HttpRequest req = HttpRequest.newBuilder()
                            .uri(
                                (new URIBuilder(BASE_URL)).setPath("update").build()
                            )
                            .GET()
                            .build();
        
        HttpResponse<String> res = HttpClient
        .newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build()
        .send(req, BodyHandlers.ofString());

        if (res.statusCode() != 200) {

            throw new HttpException("Request failed with status code: " + res.statusCode());
        }
    }
}
