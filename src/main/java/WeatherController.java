import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherController {
    @FXML private Label lblCity;
    @FXML private Label lblCurrentTemp;
    @FXML private ImageView imgviewIcon;
    @FXML private Label lblDescription;
    @FXML private TextField txtboxLocID;
    @FXML private Button btnRefresh;
    @FXML private ComboBox<String> cboxCities;

    private WeatherData model;
    private String locationID;

    public WeatherController(WeatherData model) {
        this.model = model;
        locationID = model.getLocationID();
    }

    @FXML
    public void initialize() {
        refresh();
        cboxCities.getItems().add("Birmingham");
        cboxCities.getItems().add("London");
        cboxCities.getItems().add("Oxford");

        cboxCities.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            switch (newValue) {
                case "Birmingham":
                    model.setLocationID("2655603");
                    break;
                case "London":
                    model.setLocationID("2643743");
                    break;
                case "Oxford":
                    model.setLocationID("2640729");
            }

        });
    }

    @FXML
    public void refresh() {
        model.setLocationID(locationID);
        lblCity.textProperty().bindBidirectional(model.cityProperty());
        lblCurrentTemp.textProperty().bindBidirectional(model.currTempProperty());
        lblDescription.textProperty().bindBidirectional(model.descriptionProperty());
        imgviewIcon.setImage(new Image("http://openweathermap.org/img/w/" + model.getIconID() + ".png"));
    }

}
