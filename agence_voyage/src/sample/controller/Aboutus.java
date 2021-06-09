package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;
import sample.model.User;
import sample.util.DatabaseHandler;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Aboutus  implements Initializable {



    @FXML
    private Rating rateapp;
    @FXML
    private Rating rateapp1;

    @FXML
    private Label test;

    @FXML
    void send(ActionEvent event) {
        double a=rateapp.getRating();
        DatabaseHandler.rating(User.us,a);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            User us= DatabaseHandler.userprofile(User.us);
            rateapp.setRating(us.getRating());
            //test.setText(DatabaseHandler.ratingCount());
            rateapp1.setRating(DatabaseHandler.ratingCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
