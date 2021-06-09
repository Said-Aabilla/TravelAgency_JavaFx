package sample.controller;
import sample.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.model.User;
import sample.model.reservation;
import sample.util.DatabaseHandler;
import sample.util.voyage_info;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Mesreservations  implements Initializable {

    @FXML
    private AnchorPane window;

    @FXML
    private TableView<voyage_info> table;

    @FXML
    private TableColumn<voyage_info, String> numero;

    @FXML
    private TableColumn<voyage_info, String> datereserv;

    @FXML
    private TableColumn<voyage_info, String> Vdep;

    @FXML
    private TableColumn<voyage_info, String> Varriv;

    @FXML
    private TableColumn<voyage_info, String> heuredeb;

    @FXML
    private TableColumn<voyage_info, String> libelllevoyage;

    @FXML
    private TableColumn<voyage_info, String> datedeb;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numero.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("id_bus"));
        datereserv.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("heure_fin"));
        heuredeb.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("heure_debut"));
        libelllevoyage.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("libelle_voyage"));
        datedeb.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("date_deb"));
        Varriv.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("ville_arrive"));
        Vdep.setCellValueFactory(new PropertyValueFactory<voyage_info, String>("ville_depart"));
        try {
            table.setItems(DatabaseHandler.get_mesReservation(User.us));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
