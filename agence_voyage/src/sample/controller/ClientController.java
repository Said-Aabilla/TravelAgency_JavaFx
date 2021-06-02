package sample.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.model.Voyage;
import sample.util.voyage_info;

import java.io.IOException;
import java.sql.SQLException;

public class ClientController {
    @FXML
    private AnchorPane window;

    @FXML
    private TableView<voyage_info> table;

    @FXML
    private TableColumn<voyage_info, String> idBus;

    @FXML
    private TableColumn<voyage_info, String> libellle;

    @FXML
    private TableColumn<voyage_info, String> dateDep;

    @FXML
    private TableColumn<voyage_info, String> Hdeb;

    @FXML
    private TableColumn<voyage_info, String> Harriv;

    @FXML
    private TableColumn<voyage_info, String> Vdep;

    @FXML
    private TableColumn<voyage_info, String> Varriv;

    @FXML
    private Button reserver;

    @FXML
    private Label libaff;

    @FXML
    private Label Hdaff;

    @FXML
    private Label Ddebaff;

    @FXML
    private Label Hdarriv;

    @FXML
    private Label Vdepaff;

    @FXML
    private Label Varrivaff;

   // ObservableList<voyage_info> list = Voyage.list;

    @FXML
    void printvoyage(ActionEvent event) {
        idBus.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("id_bus"));
        libellle.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("libelle_voyage"));
        Hdeb.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("heure_debut"));
        Harriv.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("heure_fin"));
        dateDep.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("date_deb"));
        Varriv.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("ville_arrive"));
        Vdep.setCellValueFactory(new PropertyValueFactory<voyage_info,String>("ville_depart"));

        table.setItems(Voyage.list);
 /*       int index = table.getSelectionModel().getFocusedIndex();
        if(index<=-1){
            return;
        }
        libaff.setText(libellle.getCellData(index));
        Hdaff.setText(Hdeb.getCellData(index));
        Hdarriv.setText(Harriv.getCellData(index));
        Ddebaff.setText(dateDep.getCellData(index));
        Varrivaff.setText(Varriv.getCellData(index));
        Vdepaff.setText(Vdep.getCellData(index));
*/
    }

    @FXML
    void reserver(ActionEvent event) {
        voyage_info V = Voyage.list.get(0);
        System.out.println(V.getVille_depart());
    }

    @FXML
    void retourner(ActionEvent event) throws IOException {
        AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ChercherBus.fxml"));
        window.getChildren().setAll(obj);
        //list = null;
    }

}



