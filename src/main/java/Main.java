import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        final WeatherData wd = new WeatherData("2643743"); //london
        System.out.println(wd.toString());

        try {
            final FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/WeatherUI.fxml"));
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