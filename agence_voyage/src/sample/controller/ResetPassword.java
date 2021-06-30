package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Client;
import sample.util.DatabaseHandler;
import sample.util.MailResetCode;

import java.io.IOException;

public class ResetPassword {
    @javafx.fxml.FXML
    @FXML
    private TextField email;

    @javafx.fxml.FXML
    @FXML
    private Button loginButton;

    @javafx.fxml.FXML
    @FXML
    void sendPassword(ActionEvent event) throws Exception {
        String ema = email.getText();
        int id_user = DatabaseHandler.retrieveIdUser(ema);
        Client cl = DatabaseHandler.clientprofile(id_user);
           if (DatabaseHandler.retrieveIdUser(ema) != 0){

               MailResetCode.sendMail(ema,cl.getPrenom_client());
               DatabaseHandler.ResetPassword(MailResetCode.newpassword,ema);
               Alert a = new Alert(Alert.AlertType.NONE);
               a.setAlertType(Alert.AlertType.INFORMATION);
               a.setContentText("Please check your email to get the new password !");
               // show the dialog
               a.show();

           }else{

           }
    }


    @javafx.fxml.FXML
    @FXML
    void retourner(ActionEvent event) throws IOException {
        loginButton.getScene().getWindow().hide();
        Stage dashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
        Scene scene = new Scene(root,800, 700);
        dashboardStage.setScene(scene);
        dashboardStage.show();
    }
}
