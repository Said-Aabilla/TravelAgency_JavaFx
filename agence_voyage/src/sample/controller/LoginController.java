package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.model.User;
import sample.util.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.util.DatabaseHandler;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
   /* @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginButton;
    @FXML*/
   @FXML
   private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;
    @FXML
    private Button cr;

    int s=0;
    public void setLoginButton(javafx.event.ActionEvent actionEvent) throws IOException {
        String uname = email.getText();
        String pass = password.getText();
        if (DatabaseHandler.CheckLoginUser(uname, pass)) { // sending data to databasehandler class to connection data
            s=DatabaseHandler.retrieveIdUser(uname);
            User.us=s;
            if(!DatabaseHandler.retreiveIdadm(DatabaseHandler.retrieveIdUser(uname))){
            loginButton.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/mainClient.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();}
            else {
                loginButton.getScene().getWindow().hide();
                Stage dashboardStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../view/confirmadm.fxml"));
                Scene scene = new Scene(root,800, 700);
                dashboardStage.setScene(scene);
                dashboardStage.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Error in login system");
            alert.show();
//            reseting user and pass field
            email.setText("");
            password.setText("");
        }
    }

    public void redirect (javafx.event.ActionEvent actionEvent) throws IOException {
        cr.getScene().getWindow().hide();
        Stage dashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        Scene scene = new Scene(root,800, 700);
        dashboardStage.setScene(scene);
        dashboardStage.show();
    }}
