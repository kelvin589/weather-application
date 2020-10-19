import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Acts as the model for the user interface
 */
public class WeatherData {
    private final String API_KEY = "ac4a0f1b15bf8f3aa7e4106d8784d837";
    private String locationID;
    private final WeatherParser wp;

    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty currTemp = new SimpleStringProperty();
    private final StringProperty iconID = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty pressure = new SimpleStringProperty();
    private final StringProperty humidity = new SimpleStringProperty();
    private final StringProperty visibility = new SimpleStringProperty();

    /**
     * Set the location id and create a new {@link WeatherParser} to get the data
     * @param locationID the location id for the location of weather
     */
    public WeatherData(String locationID) {
        this.locationID = locationID;
        wp = new WeatherParser(API_KEY, locationID);
        getData();
    }

    /**
     * Get the {@link Weather} object from the {@link WeatherParser} and use it to set
     * the various variables in this object
     */
    public void getData() {
        Weather weather = wp.getWeather();

        this.setCity(weather.name + ", " + weather.sys.country);
        this.setCurrTemp(Math.round(weather.main.temp) + "°C");
        this.setIconID(weather.weather.get(0).icon);
        this.setDescription("Feels like " + Math.round(weather.main.feels_like) + "°C. " +
                weather.weather.get(0).description);
        System.out.println(weather.sys.sunrise);
        this.setPressure("Pressure: " + Math.round(weather.main.pressure) + "hPa");
        this.setHumidity("Humidity: " + Math.round(weather.main.humidity) + "%");
        this.setVisibility("Visibility: " + weather.visibility/1000 + "km");

    }

    /**
     * Set the {@code locationID}
     * @param id the location id to change to
     */
    public void setLocationID(String id) {
        wp.setLocationID(id);
    }

    //********************
    // Various get methods for the variables
    //********************
    public String getLocationID() {
        return this.locationID;
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCurrTemp() {
        return currTemp.get();
    }

    public StringProperty currTempProperty() {
        return currTemp;
    }

    public void setCurrTemp(String currTemp) {
        this.currTemp.set(currTemp);
    }

    public String getIconID() {
        return iconID.get();
    }

    public StringProperty iconIDProperty() {
        return iconID;
    }

    public void setIconID(String iconID) {
        this.iconID.set(iconID);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getHumidity() {
        return humidity.get();
    }

    public StringProperty humidityProperty() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity.set(humidity);
    }

    public String getPressure() {
        return pressure.get();
    }

    public StringProperty pressureProperty() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure.set(pressure);
    }

    public String getVisibility() {
        return visibility.get();
    }

    public StringProperty visibilityProperty() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility.set(visibility);
    }

    /**
     * The string representation of the data
     * @return a string representation of the data
     */
    @Override
    public String toString() {
        return "City: " + getCity() + "\n" +
                "Current Temperature: " + getCurrTemp() + "\n" +
                "Icon ID:" + getIconID() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Pressure: " + getPressure() + "\n" +
                "Humidity: " + getHumidity() + "\n" +
                "Visibility: " + getVisibility();
    }
}
