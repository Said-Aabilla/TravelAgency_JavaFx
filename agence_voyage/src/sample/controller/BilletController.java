package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.util.Mail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BilletController implements Initializable  {
    @javafx.fxml.FXML
    @FXML
    private AnchorPane window;

    @javafx.fxml.FXML
    @FXML
    private Label label;

    @javafx.fxml.FXML
    @FXML
    void returnto(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ChercherBus.fxml"));
        window.getChildren().setAll(obj);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Mail.sendMail("said160aabilla@gmail.com");
            label.setText("Check your email to download the ticket !");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
