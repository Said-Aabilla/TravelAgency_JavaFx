package sample.controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.model.Voyage;
import sample.model.hotel;
import sample.util.DatabaseHandler;
import sample.util.hotel_infos;
import sample.util.voyage_info;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Hotels implements Initializable {

    @FXML
    private AnchorPane window;
    @FXML
    private TableView<hotel_infos> table;

    @FXML
    private TableColumn<hotel_infos, String> descrip;

    @FXML
    private TableColumn<hotel_infos, String> ShortDes;

    @FXML
    private TableColumn<hotel_infos, String> city;

    @FXML
    private TableColumn<hotel_infos, String> adrrss;
    @FXML
    private TableColumn<hotel_infos, String> id;

    @FXML
    private TableColumn<hotel_infos, String> prix;

    @FXML
    private TableColumn<hotel_infos, String> image;

    @FXML
    private ImageView imgView;

    @FXML
    private Label shortdesclabel;

    @FXML
    private Label pricelabel;

    @FXML
    private JFXTextArea desLabel;
    @FXML
    private Label adresselabel;

    @FXML
    private Label villelabel;


    // hotel hot =  new hotel();
    ObservableList<hotel_infos> list = null;

    public Hotels() throws SQLException {
    }

    int index = 0;

    @FXML
    void next(ActionEvent event) {
        ++ index ;
        System.out.println(index);
        if (index < 0 ) {index = 1;}

        if (index >= table.getItems().size() ) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("You have reached the last hotel !");
            // show the dialog
            a.show();
        } else {
            desLabel.setText(descrip.getCellData(index));
           // shortdesclabel.setText(ShortDes.getCellData(index));
            pricelabel.setText(prix.getCellData(index));
            villelabel.setText(city.getCellData(index));
            adresselabel.setText(adrrss.getCellData(index));
            //   im.setImage();
            try {
                if(  DatabaseHandler.image_hotel(Integer.parseInt(id.getCellData(index))) !=0)
                {
                    Image imag =new Image("file:photo.jpg",499,399,true,true);
                    imgView.setImage(imag);
                    imgView.setFitWidth(499);
                    imgView.setFitHeight(339);
                    imgView.setPreserveRatio(true);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void previous(ActionEvent event) {
        -- index ;
        System.out.println(index);
        if (index < 0) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("You have reached the first hotel !");
            // show the dialog
            a.show();
        } else {
            desLabel.setText(descrip.getCellData(index));
            //shortdesclabel.setText(ShortDes.getCellData(index));
            pricelabel.setText(prix.getCellData(index));
            villelabel.setText(city.getCellData(index));
            adresselabel.setText(adrrss.getCellData(index));
            try {
                if(  DatabaseHandler.image_hotel(Integer.parseInt(id.getCellData(index))) !=0)
                {
                    Image imag =new Image("file:photo.jpg",499,399,true,true);
                    imgView.setImage(imag);
                    imgView.setFitWidth(499);
                    imgView.setFitHeight(339);
                    imgView.setPreserveRatio(true);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //   im.setImage();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       table.setVisible(false);
        try {
            list = hotel.get_hotel_client("Agadir");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (list.isEmpty())
        {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("There are no hotels for those credentials at the moment, please try again later !!");
            // show the dialog
            a.show();
        } else{
            //remplissage de table
            table.setItems(list);
            //recuperer row count
            index = table.getItems().size();
            //remplis les labels
            descrip.setCellValueFactory(new PropertyValueFactory<hotel_infos, String>("description"));
          //  ShortDes.setCellValueFactory(new PropertyValueFactory<hotel_infos, String>("short_description"));
            prix.setCellValueFactory(new PropertyValueFactory<hotel_infos, String>("prix_range"));
            city.setCellValueFactory(new PropertyValueFactory<hotel_infos, String>("ville"));
            adrrss.setCellValueFactory(new PropertyValueFactory<hotel_infos, String>("adresse"));
            id.setCellValueFactory(new PropertyValueFactory<hotel_infos, String>("id"));
            try {
                if(  DatabaseHandler.image_hotel(Integer.parseInt(id.getCellData(0))) !=0)
                {
                    Image imag =new Image("file:photo.jpg",499,339,true,true);
                    imgView.setImage(imag);
                    imgView.setFitWidth(499);
                    imgView.setFitHeight(339);
                    imgView.setPreserveRatio(true);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //remplissage des libelle

            desLabel.setText(descrip.getCellData(0));
            //shortdesclabel.setText(ShortDes.getCellData(0));
            pricelabel.setText(prix.getCellData(0));
            villelabel.setText(city.getCellData(0));
            adresselabel.setText(adrrss.getCellData(0));
         //   im.setImage();

            }
    }

}