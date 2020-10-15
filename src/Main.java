//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("WeatherUI.fxml"));
//        primaryStage.setTitle("Weather");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter api key:");
        WeatherParser wp = new WeatherParser(scanner.nextLine());
        wp.connection();
    }
}
