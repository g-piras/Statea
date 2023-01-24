package its.statea.producer.istatapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.http.HttpException;
import org.apache.http.client.utils.URIBuilder;

class DataFetcher {
    
    static InputStream istatRecordsFetch(String isoDate) throws URISyntaxException, IOException, InterruptedException, HttpException {

        HttpRequest req = HttpRequest.newBuilder()
                            .uri(
                                (new URIBuilder("http://sdmx.istat.it/SDMXWS/rest/data/122_54/.551_553.N...TOT...ALL.ALL.ALL"))
                                .addParameter("updatedAfter", isoDate).build()
                            )
                            .GET()
                            .header("Accept", "application/vnd.sdmx.data+csv") // CSV
                            .build();
        
        HttpResponse<InputStream> res = HttpClient
        .newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build()
        .send(req, BodyHandlers.ofInputStream());

        if (res.statusCode() == 404) {

            res.body().close();
            // no new record found
            return InputStream.nullInputStream();
        }
        else if (res.statusCode() != 200) {

            res.body().close();
            throw new HttpException("Request failed with status code: " + res.statusCode());
        }

        return res.body();
    }

    static InputStream districtInfoFetch() throws URISyntaxException, IOException, InterruptedException, HttpException {

        HttpRequest req = HttpRequest.newBuilder()
                            .uri(
                                (new URIBuilder("http://sdmx.istat.it/SDMXWS/rest/data/122_54/M.551_553.N...TOT.ALL.AR.ALL.ALL.ALL")).build()
                            )
                            .GET()
                            .header("Accept", "application/vnd.sdmx.data+json") // JSON
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
}
