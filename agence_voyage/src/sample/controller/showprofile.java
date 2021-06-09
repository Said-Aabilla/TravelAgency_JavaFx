package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.model.Client;
import sample.model.User;
import sample.util.DatabaseHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class showprofile implements Initializable {

    @FXML
    private Button upd;
    @FXML
    private Pane pand;
    @FXML
    private TextField cin;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField adre;

    @FXML
    private TextField tel;

    @FXML
    private TextField codeP;

    @FXML
    private Button disp;

    @FXML
    private TextField emai;

    private FileInputStream fis;
    private File fi;
    @FXML
    private Button save;
    @FXML
    private ImageView imv;
    @FXML
    private Button brow;
    @FXML
    private Label txtar;
    @FXML
    private Button delete;
    @FXML
    private Button upl;


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
        }
        upl.setDisable(false);
    }

    @FXML
    void clickup(javafx.event.ActionEvent actionEvent) throws IOException {
        upd.getScene().getWindow().hide();
        Stage dashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/passwordreset.fxml"));
        Scene scene = new Scene(root);
        dashboardStage.setScene(scene);
        dashboardStage.show();
    }

    @FXML
    void setUpl(ActionEvent event) {
        if(DatabaseHandler.udloadimage(User.us,fis,fi)!=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("upload");
            alert.setContentText("image uploaded succcefully");
            alert.show();
        }
    }
    @FXML
    void Del(javafx.event.ActionEvent actionEvent) throws IOException {


        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Deleting accont process");
        alert.setHeaderText(null);
        alert.setContentText("Please make sure , that your entire data will be deleted when proceding \n Our company has vowed not to get in touch with its clients privacy ! \n" +
                "CLICK OK TO DELETE YOUR ACCOUNT");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            DatabaseHandler.Deleteacooreser(User.us); ; // sending data to databasehandler class to connection data
            showAlert(Alert.AlertType.CONFIRMATION,
                    "Inform", "your account is deleted !" );
            delete.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/login_.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();
        } else {

        }

    }
    @FXML
    void update(ActionEvent event) {
        String em =  emai.getText();
        String n =  nom.getText();
        String pr =  prenom.getText();
        String ci =   cin.getText();
        String tl = tel.getText();
        String ad =  adre.getText();
        String cp =  codeP.getText();
        DatabaseHandler.updateInfo( n,pr,ci,ad,tl,cp,User.us);
        showAlert(Alert.AlertType.CONFIRMATION,"Modification","Your info are now updated !");

    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pand.setVisible(true);
        pand.setManaged(true);
        try {
            if(DatabaseHandler.image(User.us)!=0) {
                Image image = new Image("file:photo.jpg", 100, 150, true, true);
                imv.setImage(image);
                txtar.setText("");
                imv.setPreserveRatio(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            User us= DatabaseHandler.userprofile(User.us);
            Client cl=DatabaseHandler.clientprofile(User.us);
            emai.setText(us.getEmail_user());
            nom.setText(cl.getNom_client());
            if(cl.getPrenom_client()!=null) {
                prenom.setText(cl.getPrenom_client());
            }
            if(cl.getCin()!=null) {
                cin.setText(cl.getCin());
            }
            if(cl.getTel_client()!=null) {
                tel.setText(cl.getTel_client());
            }
            if(cl.getAdresse_client()!=null) {
                adre.setText(cl.getAdresse_client());
            }
            if(cl.getCp_client()!=null) {
                codeP.setText(cl.getCp_client());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            try {
                throw e;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
    }

    public void setDispl(ActionEvent actionEvent) {
    }
}
