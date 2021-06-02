
package sample.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Alert;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;
        import sample.util.DatabaseHandler;

        import java.io.IOException;

public class Update {

    @FXML
    private TextField currP;

    @FXML
    private TextField newP;

    @FXML
    private Button up;

    @FXML
    void setUP(MouseEvent event) {

    }
    @FXML
    private TextField email;
    @FXML
    void setUp(ActionEvent event) throws IOException {
        String uname = currP.getText();
        String pass = newP.getText();
        String emal=email.getText();
        if (!uname.equals(pass)){
            DatabaseHandler.updatepassword(uname, pass,emal);

            up.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
            Scene scene = new Scene(root,800, 700);
            dashboardStage.setScene(scene);
            dashboardStage.show();
            showAlert(Alert.AlertType.INFORMATION,
                    "Success", "Reset password successfully!" );

        }
else {
            showAlert(Alert.AlertType.WARNING,
                    "Error", "Please don't use your old password \n or try using an email valid" );
        }

    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}