import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The controller for the main user interface.
 */
public class WeatherController {
    @FXML private Label lblCity;
    @FXML private Label lblCurrentTemp;
    @FXML private ImageView imgviewIcon;
    @FXML private Label lblDescription;
    @FXML private TextField txtboxLocID;
    @FXML private Button btnRefresh;
    @FXML private ComboBox<String> cboxCities;
    @FXML private Label lblHumidity;
    @FXML private Label lblPressure;
    @FXML private Label lblVisibility;
    @FXML private Label lblSunrise;
    @FXML private Label lblSunset;

    private WeatherData model;

    /**
     * The constructor:
     * Takes a {@link WeatherData} as the model for the UI
     * @param model a {@link WeatherData} object
     */
    public WeatherController(WeatherData model) {
        this.model = model;
    }

    /**
     * Initialise the components of the user interface by binding them to the properties in the model.
     * Add cities to the {@link ComboBox}. A listener is added to the combobox so that the location id is
     * changed when the value of the combobox is changed. The model is refreshed to show this change.
     */
    @FXML
    public void initialize() {
        lblCity.textProperty().bindBidirectional(model.cityProperty());
        lblCurrentTemp.textProperty().bindBidirectional(model.currTempProperty());
        lblDescription.textProperty().bindBidirectional(model.descriptionProperty());
        lblPressure.textProperty().bindBidirectional(model.pressureProperty());
        lblHumidity.textProperty().bindBidirectional(model.humidityProperty());
        lblVisibility.textProperty().bindBidirectional(model.visibilityProperty());
        lblSunrise.textProperty().bindBidirectional(model.sunriseProperty());
        lblSunset.textProperty().bindBidirectional(model.sunsetProperty());
        imgviewIcon.setImage(new Image("http://openweathermap.org/img/w/" + model.getIconID() + ".png"));

        cboxCities.getItems().add("Birmingham");
        cboxCities.getItems().add("London");
        cboxCities.getItems().add("Oxford");

        cboxCities.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            switch (newValue) {
                case "Birmingham":
                    model.setLocationID("2655603");
                    model.getData();
                    break;
                case "London":
                    model.setLocationID("2643743");
                    model.getData();
                    break;
                case "Oxford":
                    model.setLocationID("2640729");
                    model.getData();
            }
        });
    }

    /**
     * Refresh the model by retrieving data again
     */
    @FXML
    public void refresh() {
        model.getData();
    }
}
