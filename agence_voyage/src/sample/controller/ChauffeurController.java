package sample.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.model.Voyage;
import sample.model.chauffeur_bus;
import sample.util.methods;

public class ChauffeurController implements Initializable{

    @FXML
    private TextField txt_cherche_chauffeur;

    @FXML
    private Button chercher_chauffeur;

    @FXML
    private TextField txt_prenom_chauffeur;

    @FXML
    private TextField txt_nom_chauffeur;

    @FXML
    private TextField txt_tel_chauffeur;

    @FXML
    private TableView<chauffeur_bus> table_chauffeur;

    @FXML
    private TableColumn<chauffeur_bus, Integer> id_col_chauffeur;

    @FXML
    private TableColumn<chauffeur_bus, String> nom_col_chauffeur;

    @FXML
    private TableColumn<chauffeur_bus, String> prenom_col_chauffeur;

    @FXML
    private TableColumn<chauffeur_bus, String> tel_col_chauffeur;

    @FXML
    private Button ajouter_chauffeur;

    @FXML
    private Button modifier_chauffeur;

    @FXML
    private Button supprimer_chauffeur;
    ObservableList<chauffeur_bus> list = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	chauffeur_bus ch =new chauffeur_bus();
  	    try {
			list = ch.getAll_chauffeur();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    id_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,Integer>("id_ch"));
  	    nom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("nom_ch"));
  	    prenom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("prenom_ch"));
  	    tel_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("tel_ch"));
  		table_chauffeur.setItems(list);
    } 

    @FXML
    void ajouter_chauffeur_click(ActionEvent event) throws SQLException {
    	chauffeur_bus ch =new chauffeur_bus(0,"default",txt_nom_chauffeur.getText(),txt_prenom_chauffeur.getText(),txt_tel_chauffeur.getText());
    	ch.ajouter_ch();
    	list = ch.getAll_chauffeur();
    	 id_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,Integer>("id_ch"));
   	    nom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("nom_ch"));
   	    prenom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("prenom_ch"));
   	    tel_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("tel_ch"));
   		table_chauffeur.setItems(list);
   		methods.message("infos", "data has been added successfully !");
    }

    @FXML
    void chercher_chauffeur_click(ActionEvent event) throws SQLException {
    	chauffeur_bus ch =new chauffeur_bus();
    	list=ch.get_chauffeur(txt_cherche_chauffeur.getText());
   	 id_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,Integer>("id_ch"));
  	    nom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("nom_ch"));
  	    prenom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("prenom_ch"));
  	    tel_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("tel_ch"));
  		table_chauffeur.setItems(list);
    }

    @FXML
    void modifier_chauffeur_click(ActionEvent event) throws SQLException {
    	 int index = table_chauffeur.getSelectionModel().getSelectedIndex();
  	    if(index<=-1) {
  	    	return;
  	    }
    	chauffeur_bus ch =new chauffeur_bus(Integer.valueOf(id_col_chauffeur.getCellData(index)),"default",txt_nom_chauffeur.getText(),txt_prenom_chauffeur.getText(),txt_tel_chauffeur.getText());
    	ch.modifier_ch();
    	list = ch.getAll_chauffeur();
    	 id_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,Integer>("id_ch"));
   	    nom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("nom_ch"));
   	    prenom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("prenom_ch"));
   	    tel_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("tel_ch"));
   		table_chauffeur.setItems(list);
   		methods.message("infos", "data has been added successfully !");

    }

    @FXML
    void select(MouseEvent event) {
    	 int index = table_chauffeur.getSelectionModel().getSelectedIndex();
 	    if(index<=-1) {
 	    	return;
 	    }
 	    txt_nom_chauffeur.setText(nom_col_chauffeur.getCellData(index));
 	   txt_prenom_chauffeur.setText(prenom_col_chauffeur.getCellData(index));
 	  txt_tel_chauffeur.setText(tel_col_chauffeur.getCellData(index));
    }

    @FXML
    void supprimer_chauffeur_click(ActionEvent event) throws SQLException {
    	 int index = table_chauffeur.getSelectionModel().getSelectedIndex();
  	    if(index<=-1) {
  	    	return;
  	    }
  	  chauffeur_bus ch =new chauffeur_bus(Integer.valueOf(id_col_chauffeur.getCellData(index)));
  	  ch.supprime_ch();
  	list = ch.getAll_chauffeur();
	 id_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,Integer>("id_ch"));
	    nom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("nom_ch"));
	    prenom_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("prenom_ch"));
	    tel_col_chauffeur.setCellValueFactory(new PropertyValueFactory<chauffeur_bus,String>("tel_ch"));
		table_chauffeur.setItems(list);
		methods.message("infos", "data has been deleted successfully !");
    }

}

