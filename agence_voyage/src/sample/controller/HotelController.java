package sample.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.model.User;
import sample.model.hotel;
import sample.util.DatabaseHandler;
import sample.util.hotel_infos;
import sample.util.methods;

public class HotelController implements Initializable {

	@FXML
	private TextField pd_hotel;
	private FileInputStream fis;
	private File fi;
	@FXML
	private TextField rp_hotel;
	@FXML
	private Button chercher_hotel;

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
	private Button upload_hotel;

	@FXML
	private Button browse_hotel;

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
		pd_hotel.setText(pd_col_hotel.getCellData(index));
		des_hotel.setText(des_col_hotel.getCellData(index));
		adr_hotel.setText(adr_col_hotel.getCellData(index));
		v_hotel.setText(v_col_hotel.getCellData(index));
		rp_hotel.setText(rp_col_hotel.getCellData(index));
	}
	@FXML
	void ajouter_hotel_click(ActionEvent event) throws SQLException {
		if(hotel.is_empty_hotel(adr_hotel.getText(), rp_hotel.getText(), pd_hotel.getText(), des_hotel.getText(), v_hotel.getText())){
			methods.message("erreur"," une ou plusieurs champs ne sont pas remplir");
			return;
		}

		if(methods.length_test(adr_hotel.getText(), 50)){
			methods.message("erreur","l'adresse est trop long veuiller choisir un  autre ");
			return;
		}
		if(methods.length_test(pd_hotel.getText(), 300)){
			methods.message("erreur","short description est trop long veuiller choisir un  autre ");
			return;
		}
		if(methods.length_test(des_hotel.getText(), 500)){
			methods.message("erreur","description est trop long veuiller choisir un  autre ");
			return;
		}
		if(methods.length_test(v_hotel.getText(), 15)){
			methods.message("erreur","le nom de ville est trop long veuiller choisir un  autre ");
			return;
		}

		if(hotel.adresse_is_exist(adr_hotel.getText())){
			methods.message("erreur","l'adresse est déja existe");
			return;
		}
		if(hotel.test_prix_range(rp_hotel.getText())){
			methods.message("erreur","le prix range doit etre de type 'xxxx-xxxx'");
			return;
		}
		hotel ht = new hotel(0, "default", pd_hotel.getText(), des_hotel.getText(), adr_hotel.getText(), rp_hotel.getText(),
				0);
		ht.ajouter_hotel(v_hotel.getText());
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

		if(hotel.is_empty_hotel(adr_hotel.getText(), rp_hotel.getText(), pd_hotel.getText(), des_hotel.getText(), v_hotel.getText())){
			methods.message("erreur"," une ou plusieurs champs ne sont pas remplir");
			return;
		}
		if(methods.length_test(adr_hotel.getText(), 50)){
			methods.message("erreur","l'adresse est trop long veuiller choisir un  autre ");
			return;
		}
		if(methods.length_test(pd_hotel.getText(), 300)){
			methods.message("erreur","short description est trop long veuiller choisir un  autre ");
			return;
		}
		if(methods.length_test(pd_hotel.getText(), 500)){
			methods.message("erreur","description est trop long veuiller choisir un  autre ");
			return;
		}
		if(methods.length_test(v_hotel.getText(), 15)){
			methods.message("erreur","le nom de ville est trop long veuiller choisir un  autre ");
			return;
		}
		if(hotel.test_prix_range(rp_hotel.getText())){
			methods.message("erreur","le prix range doit etre de type 'xxxx-xxxx'");
			return;
		}
		if(hotel.adresse_is_exist(adr_hotel.getText())){
			methods.message("erreur","l'adresse est déja existe");
			return;
		}
		int index = table_hotel.getSelectionModel().getSelectedIndex();
		if(index<=-1) {
			return;
		}
		hotel ht4 = new hotel(Integer.valueOf(id_col_hotel.getCellData(index)) , "default", pd_hotel.getText(), des_hotel.getText(), adr_hotel.getText(), rp_hotel.getText(),
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
		int index = table_hotel.getSelectionModel().getSelectedIndex();
		if(index<=-1) {
			return;
		}
		hotel ht2 = new hotel(Integer.valueOf(id_col_hotel.getCellData(index)));
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
	void upload_hotel_click(ActionEvent event) throws SQLException {
		int index = table_hotel.getSelectionModel().getSelectedIndex();
		if(index<=-1) {
			return;
		}
		if(hotel.udloadimage(Integer.valueOf(id_col_hotel.getCellData(index)),fis,fi)!=0)
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("upload");
			alert.setContentText("image uploaded succcefully");
			alert.show();
		}
	}
	@FXML
	void browse_hotel_click(ActionEvent event) throws FileNotFoundException {
		FileChooser filechooser=new FileChooser();
		filechooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("image Files","*.png","*.jpg","*.jpeg")
		);
		File select=filechooser.showOpenDialog(new Stage());
		if (select !=null)
		{

			Image image=new Image(select.toURI().toString());

			fis= new FileInputStream(select);
			fi=select;
		}

	}

}
