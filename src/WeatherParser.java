import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherParser {
    private String apiKey;
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather";
    private final String locationID = "?id=2643743"; //london
    private String appID;
    public WeatherParser(String apiKey) {
        this.apiKey = apiKey;
        this.appID = "appid=" + apiKey;
    }

    public void connection() {
        try {
            URL url = new URL(openWeatherUrl + locationID + "&" + appID);
            InputStream stream = url.openStream();
            byte[] b = stream.readAllBytes();
            String s = new String(b);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
