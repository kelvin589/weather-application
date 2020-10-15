import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WeatherData {
    private final String API_KEY = "ac4a0f1b15bf8f3aa7e4106d8784d837";
    private String locationID;
    private final WeatherParser wp;

    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty currTemp = new SimpleStringProperty();
    private final StringProperty iconID = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();

    public WeatherData(String locationID) {
        this.locationID = locationID;
        wp = new WeatherParser(API_KEY, locationID);
        getData();
    }

    public void getData() {
        Weather weather = wp.getWeather();

        this.setCity(weather.name);
        this.setCurrTemp(weather.main.temp + "°C");
        this.setIconID(weather.weather.get(0).icon);
        this.setDescription(weather.weather.get(0).description);
    }

    public void setLocationID(String id) {
        wp.setLocationID(id);
        getData();
    }

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

    @Override
    public String toString() {
        return "City: " + getCity() + "\n" +
                "Current Temperature: " + getCurrTemp() + "\n" +
                "Icon ID:" + getIconID() + "\n" +
                "Description: " + getDescription();
    }
}
