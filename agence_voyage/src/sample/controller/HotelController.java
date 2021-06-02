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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.model.hotel;
import sample.util.hotel_infos;
import sample.util.methods;

public class HotelController implements Initializable {

    @FXML
    private TextField pd_hotel;

    @FXML
    private TextField rp_hotel;
    @FXML
    private Button chercher_hotel;
    @FXML
    private TextField id_hotel;

    @FXML
    private TextField adr_hotel;

    @FXML
    private TextField v_hotel;

    @FXML
    private TextArea des_hotel;

    @FXML
    private TextField txt_chercher_hotel;

    @FXML
    private Button ajouter_hotel;

    @FXML
    private Button modifier_hotel;

    @FXML
    private Button supprimer_hotel;

    @FXML
    private TableView<hotel_infos> table_hotel;
    @FXML
    private TableColumn<hotel_infos, String> id_col_hotel;

    @FXML
    private TableColumn<hotel_infos, String> pd_col_hotel;

    @FXML
    private TableColumn<hotel_infos, String> des_col_hotel;

    @FXML
    private TableColumn<hotel_infos, String> adr_col_hotel;

    @FXML
    private TableColumn<hotel_infos, String> rp_col_hotel;

    @FXML
    private TableColumn<hotel_infos, String> v_col_hotel;
    ObservableList<hotel_infos> list = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 hotel ht4 =new hotel();
  	    try {
			list = ht4.getAll_hotel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    id_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("id"));
  	    pd_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("short_description"));
  		des_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("description"));
  		adr_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("adresse"));
  		rp_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("prix_range"));
  		v_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("ville"));
  		table_hotel.setItems(list);
    }  
    @FXML
    void select(MouseEvent event) {
    int index = table_hotel.getSelectionModel().getSelectedIndex();
    if(index<=-1) {
    	return;
    }
    id_hotel.setText(id_col_hotel.getCellData(index));
	pd_hotel.setText(pd_col_hotel.getCellData(index));
	des_hotel.setText(des_col_hotel.getCellData(index));
	adr_hotel.setText(adr_col_hotel.getCellData(index));
	v_hotel.setText(v_col_hotel.getCellData(index));
	rp_hotel.setText(rp_col_hotel.getCellData(index));
    }
    @FXML
    void ajouter_hotel_click(ActionEvent event) throws SQLException {
    	hotel ht = new hotel(Integer.valueOf(id_hotel.getText()) , "default", pd_hotel.getText(), des_hotel.getText(), adr_hotel.getText(), rp_hotel.getText(),
    			0);
    	ht.ajouter_hotel(v_hotel.getText());
    	id_hotel.setText("");
    	pd_hotel.setText("");
    	des_hotel.setText("");
    	adr_hotel.setText("");
    	v_hotel.setText("");
    	rp_hotel.setText("");
    	 hotel ht1 =new hotel();
 	    list = ht1.getAll_hotel();
 	    id_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("id"));
 	    pd_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("short_description"));
 		des_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("description"));
 		adr_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("adresse"));
 		rp_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("prix_range"));
 		v_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("ville"));
 		table_hotel.setItems(list);
 		methods.message("infos", "data has been added successfully !");
    }

    @FXML
    void chercher_hotel_click(ActionEvent event) throws SQLException {
    	 hotel ht =new hotel();
    	    list = ht.get_hotel(txt_chercher_hotel.getText());
    	    id_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("id"));
    	    pd_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("short_description"));
    		des_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("description"));
    		adr_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("adresse"));
    		rp_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("prix_range"));
    		v_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("ville"));
    		table_hotel.setItems(list);
    }

    @FXML
    void modifier_hotel_click(ActionEvent event) throws SQLException {
    	hotel ht4 = new hotel(Integer.valueOf(id_hotel.getText()) , "default", pd_hotel.getText(), des_hotel.getText(), adr_hotel.getText(), rp_hotel.getText(),
    			0);
    	ht4.modifier_hotel(v_hotel.getText());
    	 hotel ht1 =new hotel();
  	    list = ht1.getAll_hotel();
  	    id_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("id"));
  	    pd_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("short_description"));
  		des_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("description"));
  		adr_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("adresse"));
  		rp_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("prix_range"));
  		v_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("ville"));
  		table_hotel.setItems(list);
    	methods.message("infos", "data has been update successfully !");
    }

    @FXML
    void supprimer_hotel_click(ActionEvent event) throws SQLException {
     hotel ht2 = new hotel(Integer.valueOf(id_hotel.getText()));
     ht2.supprime_hotel();
     hotel ht1 =new hotel();
	    list = ht1.getAll_hotel();
	    id_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("id"));
	    pd_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("short_description"));
		des_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("description"));
		adr_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("adresse"));
		rp_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("prix_range"));
		v_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("ville"));
		table_hotel.setItems(list);
     methods.message("infos", "data has been deleted successfully !");
    }

   @FXML
    void txt_cherche_hotel_keypress(KeyEvent event) throws SQLException {
     /*hotel ht =new hotel();
    list = ht.get_hotel(txt_chercher_hotel.getText());
    id_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("id"));
    pd_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("short_description"));
	des_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("description"));
	adr_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("adresse"));
	rp_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("prix_range"));
	v_col_hotel.setCellValueFactory(new PropertyValueFactory<hotel_infos,String>("ville"));
	table_hotel.setItems(list);*/
    }

}
