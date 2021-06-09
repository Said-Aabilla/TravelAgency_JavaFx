package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.model.Client;
import sample.util.DatabaseHandler;
import sample.util.MailResetCode;

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

           }else{

           }
    }
}
