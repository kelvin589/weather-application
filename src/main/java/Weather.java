import java.util.List;

/**
 * An object to hold information retrieved from the weather API
 */
public class Weather {
    WeatherCoord coord;
    List<WeatherWeatherItems> weather;
    String base;
    WeatherMain main;
    double visibility;
    WeatherWind wind;
    WeatherClouds clouds;
    String dt;
    WeatherSys sys;
    int timezone;
    String id;
    String name;
    String cod;

    public class WeatherCoord {
        String lon;
        String lat;
    }

    public class WeatherWeatherItems {
        String id;
        String main;
        String description;
        String icon;
    }

    public class WeatherMain {
        double temp;
        double feels_like;
        double temp_min;
        double temp_max;
        double pressure;
        double humidity;
    }

    public class WeatherWind {
        String speed;
        String deg;
    }

    public class WeatherClouds {
        String all;
    }

    public class WeatherSys {
        String type;
        String id;
        String message;
        String country;
        long sunrise;
        long sunset;
    }
}
