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
import sample.model.bus;
import sample.model.chauffeur_bus;

public class BusController  implements Initializable{

    @FXML
    private TextField txt_cherche_bus;

    @FXML
    private Button cherche_bus;

    @FXML
    private TextField txt_lib_bus;

    @FXML
    private TextField txt_mat_bus;

    @FXML
    private TextField txt_ch_bus;

    @FXML
    private TextField txt_cat_bus;

    @FXML
    private TableView<bus> table_view;

    @FXML
    private TableColumn<bus, Integer> id_col_bus;

    @FXML
    private TableColumn<bus, String> lib_col_bus;

    @FXML
    private TableColumn<bus, String> mat_col_bus;

    @FXML
    private TableColumn<bus, Integer> ch_col_bus;

    @FXML
    private TableColumn<bus, Integer> cat_col_bus;

    @FXML
    private Button ajouter_bus;

    @FXML
    private Button modifier_bus;

    @FXML
    private Button supprimer_bus;
    ObservableList<bus> list = null;

    @FXML
    void ajouter_bus_click(ActionEvent event) throws SQLException {
      bus b=new bus(0,"default",txt_lib_bus.getText(),txt_mat_bus.getText(),Integer.valueOf(txt_ch_bus.getText()),Integer.valueOf(txt_cat_bus.getText()));
      b.ajouter_bus();
      list = b.getAll_bus();
      id_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("id_bus"));
	    lib_col_bus.setCellValueFactory(new PropertyValueFactory<bus,String>("nom_bus"));
	    mat_col_bus.setCellValueFactory(new PropertyValueFactory<bus,String>("immatriculation"));
	    ch_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("id_ch"));
	    cat_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("num_cb"));
		table_view.setItems(list);
    }

    @FXML
    void cherche_bus_click(ActionEvent event) {

    }

    @FXML
    void modifier_bus_click(ActionEvent event) {

    }

    @FXML
    void select(MouseEvent event) {
   	 int index = table_view.getSelectionModel().getSelectedIndex();
	    if(index<=-1) {
	    	return;
	    }
	    txt_lib_bus.setText(lib_col_bus.getCellData(index));
	    txt_mat_bus.setText(mat_col_bus.getCellData(index));
	    txt_ch_bus.setText(String.valueOf(ch_col_bus.getCellData(index)));
	    txt_cat_bus.setText(String.valueOf(cat_col_bus.getCellData(index)));
    }

    @FXML
    void supprimer_bus_click(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bus b =new bus();
  	    try {
			list = b.getAll_bus();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    id_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("id_bus"));
  	    lib_col_bus.setCellValueFactory(new PropertyValueFactory<bus,String>("nom_bus"));
  	    mat_col_bus.setCellValueFactory(new PropertyValueFactory<bus,String>("immatriculation"));
  	    ch_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("id_ch"));
  	    cat_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("num_cb"));
  		table_view.setItems(list);
	}

}

