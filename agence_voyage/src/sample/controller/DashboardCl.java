package sample.controller;


        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.control.Button;
        import javafx.scene.layout.AnchorPane;

        import java.io.IOException;

 public class DashboardCl {

    @FXML
    private Button acc;

    @FXML
    private AnchorPane window;

    @FXML
    void profile(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ProfileClientt.fxml"));
        window.getChildren().setAll(obj);
    }

     @FXML
     void AfficherChercher(ActionEvent event) throws IOException {
         AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ChercherBus.fxml"));
         window.getChildren().setAll(obj);
     }
}