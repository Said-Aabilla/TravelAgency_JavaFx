package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
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

import java.io.IOException;

public class LoginController {
   /* @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginButton;*/
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
            if (DatabaseHandler.checkreset(uname)){
                forgot_password.getScene().getWindow().hide();
                Stage dashboardStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../view/passwordreset.fxml"));
                Scene scene = new Scene(root);
                dashboardStage.setScene(scene);
                dashboardStage.show();
            }
           else {
            s=DatabaseHandler.retrieveIdUser(uname);
            User.us=s;
            System.out.println(User.em=uname);
            if(!DatabaseHandler.retreiveIdadm(DatabaseHandler.retrieveIdUser(uname))){
            loginButton.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();}
            else {
                loginButton.getScene().getWindow().hide();
                Stage dashboardStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../view/confirmadmin.fxml"));
                Scene scene = new Scene(root,411, 278);
                dashboardStage.setScene(scene);
                dashboardStage.show();
            }}
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
    }

    @FXML
    private Button forgot_password;

    @FXML
    void forgot_password(ActionEvent event) throws IOException {

        forgot_password.getScene().getWindow().hide();
        Stage dashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/ResetPassword.fxml"));
        Scene scene = new Scene(root,350, 260);
        dashboardStage.setScene(scene);
        dashboardStage.show();
    }
}
