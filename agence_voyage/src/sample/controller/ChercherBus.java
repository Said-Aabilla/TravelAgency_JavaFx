package sample.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.model.Voyage;
import sample.util.voyage_info;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

public class ChercherBus {

    @FXML
    private TextField villeD;

    @FXML
    private TextField villeA;

    @FXML
    private TextField dt;
    @FXML
    private AnchorPane window;


     Voyage v1 = new Voyage();
    // create a alert
    Alert a = new Alert(Alert.AlertType.NONE);
    //my own function to test if a string is numeric
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    @FXML
    void chercherVoyage(javafx.event.ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        String vd = villeD.getText().toUpperCase(Locale.ROOT);
        String va = villeA.getText().toUpperCase();
        if ((va.isEmpty() && vd.isEmpty())) {
            // set alert type
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Vous devez remplissez au moin les champs des villes !!");
            // show the dialog
            a.show();
        } else if ((va.length()>14 && vd.length()>14) || (isNumeric(va)) ||(isNumeric(vd))) {
            // set alert type
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Aucun ville avec ce nom !!");
            // show the dialog
            a.show();
        }  else if (!(dt.getText().matches("\\d{4}-\\d{2}-\\d{2}"))) {
            // set alert type
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Format du date est invalide !!");
            // show the dialog
            a.show();
        }else {
            try {
                v1.get_voyage(villeD.getText(), villeA.getText(), dt.getText());

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Error occurred while getting Voyages information from DB.\n" + e);
                throw e;
            }
            AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ClientVoyage.fxml"));
            window.getChildren().setAll(obj);
        }

    }

}
