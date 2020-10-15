import java.util.List;

public class Weather {
    WeatherCoord coord;
    List<WeatherWeatherItems> weather;
    String base;
    WeatherMain main;
    String visibility;
    WeatherWind wind;
    WeatherClouds clouds;
    String dt;
    WeatherSys sys;
    String timezone;
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
        String temp;
        String feels_like;
        String temp_min;
        String temp_max;
        String pressure;
        String humidity;
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
        String sunrise;
        String sunset;
    }
}
