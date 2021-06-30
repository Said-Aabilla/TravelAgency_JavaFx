package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.util.DatabaseHandler;

import java.io.IOException;
import java.sql.SQLException;

public class signupcontroller {
    @FXML
    private TextField name;

    @FXML
    private PasswordField passw;

    @FXML
    private TextField numTel;

    @FXML
    private TextField emai;

    @FXML
    private TextField Cin;

    @FXML
    private PasswordField passwCon;

    @FXML
    private Button log;
    @FXML
    private Button reg;

    public void signup(javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
        String emailcheck = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        String telcheck="^[0-9]{10,}";
        String cincheck="[a-z]{2}[0-9]{4,20}";
        String usercheck="[a-zA-Z]*";
        String uname = emai.getText();
        String nom = name.getText();
        String pass = passw.getText();
        String cin = Cin.getText();
        String numtel = numTel.getText();
        String passcon = passwCon.getText();
        if(nom.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter your name");
            return;
        }
            if(uname.isEmpty()) {
                showAlert(Alert.AlertType.ERROR,
                        "Form Error!", "Please enter your email ");
                return;
            }
            if(!nom.matches(usercheck)){
                showAlert(Alert.AlertType.ERROR,
                        "Form Error!", "not a valid username !");
                return;
            }
        if(!uname.matches(emailcheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid email !");
            return;
        }
        if(numtel.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "your phone number is required");
            return;
        }
        if(!numtel.matches(telcheck)) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid number");
            return;
        }
        if(cin.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter your cin");
            return;
        }
        if(!cin.matches(cincheck))
        {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid cin");
            return;
        }

        if(pass.isEmpty()) {
                showAlert(Alert.AlertType.ERROR,
                        "Form Error!", "Please enter a password");
                return;
            }
        if(passcon.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter your confirm password");
            return;
        }


        if(DatabaseHandler.ChecksignupUserbo(uname,pass,cin,numtel,nom)!=0)
        {
            if(pass.equals(passcon) ) {

            if(pass.matches(pattern)){
            reg.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();
                showAlert(Alert.AlertType.CONFIRMATION,
                        "Welcome", "Registration Successful! \n Log in now to proceed ." );
            }
            else{
                showAlert(Alert.AlertType.CONFIRMATION,
                        "Warning", "please enter a strong password : 8 characters at least , special characters : example '123@abE9*' " );
            }

            }
            else {
                showAlert(Alert.AlertType.ERROR,
                        "Form Error!", "mismatch password");
            }
        }
        else
        {
            showAlert(Alert.AlertType.CONFIRMATION,
                    "Retry!", "that email is already existed" );
        }
      /*  emai.setText("");
        passw.setText("");
        numTel.setText("");
        passwCon.setText("");
        Cin.setText("");
        name.setText("");*/



    }
    private void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }


    public void goLog(ActionEvent actionEvent) throws IOException {
        log.getScene().getWindow().hide();
        Stage dashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
        Scene scene = new Scene(root);
        dashboardStage.setScene(scene);
        dashboardStage.show();
    }

}