package sample.controller;


        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
        import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

 public class DashboardCl {

    @FXML
    private Button acc;

    @FXML
    private AnchorPane window;
    
    @FXML
    private Button logout1;
    
    @FXML
    void LogOut(ActionEvent event) throws IOException {
    	  logout1.getScene().getWindow().hide();
          Stage dashboardStage = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
          Scene scene = new Scene(root,800, 700);
          dashboardStage.setScene(scene);
          dashboardStage.show();

    }

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