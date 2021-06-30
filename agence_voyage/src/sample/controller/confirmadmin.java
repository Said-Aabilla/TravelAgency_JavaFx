package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.util.DatabaseHandler;

import java.io.IOException;

public class confirmadmin {

    @javafx.fxml.FXML
    @FXML
    private TextField matricule;

    @javafx.fxml.FXML
    @FXML
    private Button confirm;

    @javafx.fxml.FXML
    @FXML
    void setConfirmButton(ActionEvent event) throws IOException {
        String mat=matricule.getText();
        if(DatabaseHandler.confirmadm(mat)) {
            confirm.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/AdminDashboard.fxml"));
            Scene scene = new Scene(root, 950, 600);
            dashboardStage.setScene(scene);
            dashboardStage.show();
        }
        else{
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
            Scene scene = new Scene(root, 800, 700);
            dashboardStage.setScene(scene);
            dashboardStage.show();
        }
    }




}
