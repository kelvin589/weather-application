import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
     * to deserialise the JSON data returned from the api, into a {@link Weather} object.
     * @return the {@link Weather} object containing data retrieved from the API
     */
    public Weather getWeather() {
        //TODO: Check status codes
        try (InputStream stream = new URL(openWeatherUrl + locationID + appID + metricUnit).openStream()){
            Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            return gson.fromJson(reader, Weather.class);
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
