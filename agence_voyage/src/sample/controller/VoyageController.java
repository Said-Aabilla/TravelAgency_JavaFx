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
import sample.model.hotel;
import sample.util.hotel_infos;
import sample.util.methods;

public class VoyageController implements Initializable{

    @FXML
    private TextField txt_ville;

    @FXML
    private TextField txt_date;

    @FXML
    private Button chercher_voyage;

    @FXML
    private TextField txt_id_bus;

    @FXML
    private TextField txt_vd_voyage;

    @FXML
    private TextField txt_ha_voyage;

    @FXML
    private TextField txt_hd_voyage;

    @FXML
    private TextField txt_da_voyage;

    @FXML
    private TextField txt_dd_voyage;

    @FXML
    private TextField txt_va_voyage;

    @FXML
    private TableView<Voyage> table_voyage;

    @FXML
    private TableColumn<Voyage, Integer> id_col_voyage;

    @FXML
    private TableColumn<Voyage, String> dd_col_voyage;

    @FXML
    private TableColumn<Voyage, String> da_col_voyage;

    @FXML
    private TableColumn<Voyage, String> hd_col_voyage;

    @FXML
    private TableColumn<Voyage, String> ha_col_voyage;

    @FXML
    private TableColumn<Voyage, String> vp_col_voyage;

    @FXML
    private TableColumn<Voyage, String> va_col_voyage;

    @FXML
    private Button ajouter_voyage;

    @FXML
    private Button modifier_voyage;

    @FXML
    private Button supprimer_voyage;
    ObservableList<Voyage> list = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	Voyage v =new Voyage();
  	    try {
			list = v.getAll_voyage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    id_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("id_voyage"));
  	    dd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_deb"));
  	    da_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_fin"));
  	    hd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_debut"));
  	    ha_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_fin"));
  	    vp_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_depart"));
  	    va_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_arrive"));
  		table_voyage.setItems(list);
    } 

    @FXML
    void ajouter_voyage_click(ActionEvent event) throws SQLException {
    	Voyage v= new Voyage(0,"default",txt_dd_voyage.getText(),txt_da_voyage.getText(),txt_hd_voyage.getText()
    			,txt_ha_voyage.getText(),Integer.valueOf(txt_id_bus.getText()),txt_vd_voyage.getText(),txt_va_voyage.getText());
    	v.ajouter_voyage();
	    list = v.get_voyage1(txt_ville.getText(),txt_date.getText());
  	    id_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("id_voyage"));
  	    dd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_deb"));
  	    da_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_fin"));
  	    hd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_debut"));
  	    ha_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_fin"));
  	    vp_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_depart"));
  	    va_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_arrive"));
  		table_voyage.setItems(list);
    	methods.message("infos", "data has been added successfully !");
    }

    @FXML
    void chercher_voyage_click(ActionEvent event) throws SQLException {
    	Voyage v =new Voyage();
	    list = v.get_voyage1(txt_ville.getText(),txt_date.getText());
  	    id_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("id_voyage"));
  	    dd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_deb"));
  	    da_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_fin"));
  	    hd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_debut"));
  	    ha_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_fin"));
  	    vp_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_depart"));
  	    va_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_arrive"));
  		table_voyage.setItems(list);
    }

    @FXML
    void modifier_voyage_click(ActionEvent event) throws SQLException {
    	Voyage v= new Voyage(id_col_voyage.getCellData(index),"default",txt_dd_voyage.getText(),txt_da_voyage.getText(),txt_hd_voyage.getText()
    			,txt_ha_voyage.getText(),Integer.valueOf(txt_id_bus.getText()),txt_vd_voyage.getText(),txt_va_voyage.getText());
    	v.modifier_voyage();
	    list = v.get_voyage1(txt_ville.getText(),txt_date.getText());
  	    id_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("id_voyage"));
  	    dd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_deb"));
  	    da_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_fin"));
  	    hd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_debut"));
  	    ha_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_fin"));
  	    vp_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_depart"));
  	    va_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_arrive"));
  		table_voyage.setItems(list);
    	methods.message("infos", "data has been update successfully !");
    }
    int index=0;
    @FXML
    void select(MouseEvent event) throws SQLException {
    	 index = table_voyage.getSelectionModel().getSelectedIndex();
    	    if(index<=-1) {
    	    	return;
    	    }
    	    Voyage v =new Voyage();
    	    txt_id_bus.setText(String.valueOf(v.get_id_bus(Integer.valueOf(id_col_voyage.getCellData(index)))));
    		txt_dd_voyage.setText(dd_col_voyage.getCellData(index));
    		txt_da_voyage.setText(da_col_voyage.getCellData(index));
    		txt_hd_voyage.setText(hd_col_voyage.getCellData(index));
    		txt_ha_voyage.setText(ha_col_voyage.getCellData(index));
    		txt_vd_voyage.setText(vp_col_voyage.getCellData(index));
    		txt_va_voyage.setText(va_col_voyage.getCellData(index));
    }

    @FXML
    void supprimer_voyage_click(ActionEvent event) throws SQLException {
    Voyage v = new Voyage(id_col_voyage.getCellData(index));
    v.supprime_voyage();
    list = v.get_voyage1(txt_ville.getText(),txt_date.getText());
	    id_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,Integer>("id_voyage"));
	    dd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_deb"));
	    da_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("date_fin"));
	    hd_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_debut"));
	    ha_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("heure_fin"));
	    vp_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_depart"));
	    va_col_voyage.setCellValueFactory(new PropertyValueFactory<Voyage,String>("ville_arrive"));
		table_voyage.setItems(list);
    methods.message("infos", "data has been deleted successfully !");
    }

}

