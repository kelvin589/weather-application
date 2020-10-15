import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WeatherParser {
    private String apiKey;
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather";
    private String locationID;
    private String appID;
    private String metricUnit;

    public WeatherParser(String apiKey, String locationID) {
        this.apiKey = apiKey;
        this.appID = "&appid=" + apiKey;
        this.locationID = "?id=" + locationID;
        this.metricUnit = "&units=metric";
    }

    public Weather getWeather() {
        try (InputStream stream = new URL(openWeatherUrl + locationID + appID + metricUnit).openStream()){
            Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            return gson.fromJson(reader, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLocationID(String id) {
        this.locationID = "?id=" + id;
    }
}
