package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboard {

        @javafx.fxml.FXML
        @FXML
        private Button voyage;

        @javafx.fxml.FXML
        @FXML
        private Button bus_manage;

        @javafx.fxml.FXML
        @FXML
        private ImageView chauffeur_manage;

        @javafx.fxml.FXML
        @FXML
        private Button hotel_manage;

        @javafx.fxml.FXML
        @FXML
        private Button log;

        @javafx.fxml.FXML
        @FXML
        private AnchorPane wind;

    @javafx.fxml.FXML
    @FXML
    void LogOut(ActionEvent event) throws IOException {
        log.getScene().getWindow().hide();
        Stage dashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
        Scene scene = new Scene(root,800, 700);
        dashboardStage.setScene(scene);
        dashboardStage.show();

    }

    @javafx.fxml.FXML
    @FXML
    void hotel_manage_clicked(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/Hotel.fxml"));
        wind.getChildren().setAll(obj);
    }
    @javafx.fxml.FXML
    @FXML
    void voyage_manage_clicked(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/VoyageAdmin.fxml"));
        wind.getChildren().setAll(obj);
    }
    @javafx.fxml.FXML
    @FXML
    void bus_manage_clicked(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/BusInterface.fxml"));
        wind.getChildren().setAll(obj);
    }
    @javafx.fxml.FXML
    @FXML
    void chauffeur_manage_clicked(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/Chauffeur.fxml"));
        wind.getChildren().setAll(obj);
    }


}
