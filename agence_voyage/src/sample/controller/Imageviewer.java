package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.util.DatabaseHandler;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Imageviewer {
    private FileInputStream fis;
    private File fi;
    @FXML
    private Button save;
    @FXML
    private ImageView imv;
    @FXML
    private Button brow;
    @FXML
    private TextArea txtar;

    @FXML

    void setBrow(ActionEvent event) throws FileNotFoundException {
       FileChooser filechooser=new FileChooser();
       filechooser.getExtensionFilters().addAll(
               new FileChooser.ExtensionFilter("image Files","*.png","*.jpg","*.jpeg")
       );
        File select=filechooser.showOpenDialog(new Stage());
        if (select !=null)
        {
        txtar.setText(select.getAbsolutePath());
        Image image=new Image(select.toURI().toString());
        imv.setImage(image);
        imv.setPreserveRatio(true);
            fis= new FileInputStream(select);
            fi=select;
}}

    @FXML void showim(ActionEvent event) throws SQLException, IOException {
            DatabaseHandler.image(5);
           Image image=new Image("file:photo.jpg",100,150,true,true);
           imv.setImage(image);
           imv.setFitWidth(100);
           imv.setFitHeight(150);
           imv.setPreserveRatio(true);
    }
    @FXML
    void setUpl(ActionEvent event) {
    if(DatabaseHandler.udloadimage(12,fis,fi)!=0)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("upload");
        alert.setContentText("image uploaded succcefully");
        alert.show();
    }
    }
}