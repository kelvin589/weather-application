import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main entry point into the weather program. Creates a new {@link WeatherData} to keep track
 * of the data. This is used for the {@link WeatherController} and the controller is linked to the UI
 * then the stage is shown.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        final WeatherData wd = new WeatherData("2643743"); //london
        System.out.println(wd.toString());

        try {
            final FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/fxml/WeatherUI.fxml"));
            l.setController(new WeatherController(wd));
            final Parent root = l.load();
            primaryStage.setTitle("Weather");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}