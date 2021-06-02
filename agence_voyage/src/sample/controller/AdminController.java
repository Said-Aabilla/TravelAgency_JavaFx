package sample.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private Button hotel_manage;
    @FXML
    private Button voyage_manage;
    @FXML
    private Button bus_manage;

    @FXML
    private Button chauffeur_manage;

    @FXML
    private AnchorPane window;


    @FXML
    private Button logout;
    
    @FXML
    void LogOut(ActionEvent event) throws IOException {
    	  logout.getScene().getWindow().hide();
          Stage dashboardStage = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
          Scene scene = new Scene(root,800, 700);
          dashboardStage.setScene(scene);
          dashboardStage.show();

    }
    
    @FXML
    void hotel_manage_clicked(ActionEvent event) throws IOException {
    	 AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/Hotel.fxml")); 
    	 window.getChildren().setAll(obj);
    }
    @FXML
    void voyage_manage_clicked(ActionEvent event) throws IOException {
    	 AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/VoyageAdmin.fxml")); 
    	 window.getChildren().setAll(obj);
    }
    @FXML
    void bus_manage_clicked(ActionEvent event) throws IOException {
    	 AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/BusInterface.fxml")); 
    	 window.getChildren().setAll(obj);
    }
    @FXML
    void chauffeur_manage_clicked(ActionEvent event) throws IOException {
   	 AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/Chauffeur.fxml")); 
   	 window.getChildren().setAll(obj);
    }

}

