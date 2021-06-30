package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.util.Mail;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login_.fxml"));
        primaryStage.setTitle("TravelGO");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
    }

      //update.fxml fiha muchkil
    //a propos de nous tahi amabghatch
    //login mataydkhlnich
    
    public static void main(String[] args) throws Exception {
        launch(args);

    }
}
