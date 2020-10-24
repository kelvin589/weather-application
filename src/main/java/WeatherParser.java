import com.google.gson.Gson;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Deserialise the JSON format received from the API into a {@link Weather} object.
 */
public class WeatherParser {
    private String apiKey;
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather";
    private String locationID;
    private String appID;
    private String metricUnit;

    /**
     * The constructor:
     * Sets the appid, id and units parameters for the API request
     * @param apiKey your api key for openweathermap
     * @param locationID the location id (can be found in the documentation for openweathermap)
     */
    public WeatherParser(String apiKey, String locationID) {
        //TODO: Change the way parameters are set for the API request
        this.apiKey = apiKey;
        this.appID = "&appid=" + apiKey;
        this.locationID = "?id=" + locationID;
        this.metricUnit = "&units=metric";
    }

    /**
     * Creates a new {@link URL} using the openweathermap url and the given parameters. {@link Gson} is used
     * to deserialise the JSON data returned from the api, into a {@link Weather} object. Returns null if
     * it was not possible to retrieve data.
     * @return the {@link Weather} object containing data retrieved from the API
     */
    public Weather getWeather() {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(openWeatherUrl + locationID + appID + metricUnit))
                    .timeout(Duration.ofSeconds(30))
                    .GET()
                    .build();
            CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                    .build()
                    .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.thenApply(HttpResponse::statusCode).get();
            if (statusCode >= 500) {
                System.out.println("Server error - server failed to fulfill a valid request");
                return null;
            }
            if (statusCode == 401) {
                System.out.println("An error has occurred due to your API key.");
                return null;
            }
            if (statusCode == 404) {
                System.out.println("An error has occurred in your request.");
                return null;
            }
            if (statusCode == 429) {
                System.out.println("Upgrade your tier; You have made more than 60 API calls per minute.");
                return null;
            }
            if (statusCode >= 400) {
                System.out.println("Client sent an invalid request");
                return null;
            }

            String result = response.thenApply(HttpResponse::body).get();
            Gson gson = new Gson();
            return gson.fromJson(result, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Change the location id requested
     * @param id the new id to set
     */
    public void setLocationID(String id) {
        this.locationID = "?id=" + id;
    }
}
