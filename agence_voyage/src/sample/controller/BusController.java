package sample.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.model.bus;
import sample.model.chauffeur_bus;
import sample.util.methods;

public class BusController  implements Initializable{
    @FXML
    private Button show_bus1;
    @FXML
    private TextField txt_cherche_bus;
    @FXML
    private TextField txt_id_bus;
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

    String idcheck="^[0-9]{10,}";
    String buscheck="[a-zA-Z]*";

    private void showAlert(Alert.AlertType alertType,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    void ajouter_bus_click(ActionEvent event) throws SQLException {

        String lib_bus=txt_lib_bus.getText();
        String mat_bus = txt_mat_bus.getText();
        int ch_bus = Integer.valueOf(txt_ch_bus.getText());
        int cat_bus =Integer.valueOf(txt_cat_bus.getText());

        if(lib_bus.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus label");
            return;
        }
        if(mat_bus.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus matricule");
            return;
        }
        if(txt_ch_bus.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter id chauffeur");
            return;
        }
        if(txt_cat_bus.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus category");
            return;
        }

/*
        if(!lib_bus.matches(buscheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus label !");
            return;
        }
        if(!mat_bus .matches(buscheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus matricul !");
            return;
        }
        if(!txt_ch_bus.getText().matches(idcheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus chauffeur !");
            return;
        }
        if(!txt_cat_bus.getText().matches(idcheck )){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus category !");
            return;
        }

*/


        bus b=new bus("0","default",lib_bus,mat_bus,txt_ch_bus.getText(),txt_cat_bus.getText());
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
    void cherche_bus_click(ActionEvent event) throws SQLException {

        String cherche_bus = txt_cherche_bus.getText();

        if(!cherche_bus .matches(buscheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus libel  !");
            return;
        }
        if(cherche_bus.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus libel ");
            return;
        }


        bus b1=new bus();
        list=b1.get_bus(txt_cherche_bus.getText());
        id_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("id_bus"));
        lib_col_bus.setCellValueFactory(new PropertyValueFactory<bus,String>("nom_bus"));
        mat_col_bus.setCellValueFactory(new PropertyValueFactory<bus,String>("immatriculation"));
        ch_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("id_ch"));
        cat_col_bus.setCellValueFactory(new PropertyValueFactory<bus,Integer>("num_cb"));
        table_view.setItems(list);



    }

    @FXML
    void modifier_bus_click(ActionEvent event) throws SQLException {

        String lib_bus=txt_lib_bus.getText();
        String mat_bus = txt_mat_bus.getText();
        int ch_bus = Integer.valueOf(txt_ch_bus.getText());
        int cat_bus =Integer.valueOf(txt_cat_bus.getText());

        if(lib_bus.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus label");
            return;
        }
        if(mat_bus.isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus matricule");
            return;
        }
        if(txt_ch_bus.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter id chauffeur");
            return;
        }
        if(txt_cat_bus.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "Please enter bus category");
            return;
        }


        if(!lib_bus.matches(buscheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus label !");
            return;
        }
        if(!mat_bus .matches(buscheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus matricule !");
            return;
        }
        if(!txt_ch_bus.getText().matches(idcheck)){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus chauffeur !");
            return;
        }
        if(!txt_cat_bus.getText().matches(idcheck )){
            showAlert(Alert.AlertType.ERROR,
                    "Form Error!", "not a valid bus category !");
            return;
        }

        int index = table_view.getSelectionModel().getSelectedIndex();



        //il faut ajouter le nom de bus
        bus ch = new bus(String.valueOf(id_col_bus.getCellData(index)), "default", "nom_bus", txt_mat_bus.getText(), txt_ch_bus.getText(), txt_cat_bus.getText());
        ch.modifier_bus();
        list = ch.getAll_bus();
        id_col_bus.setCellValueFactory(new PropertyValueFactory<bus, Integer>("id_bus"));
        lib_col_bus.setCellValueFactory(new PropertyValueFactory<bus, String>("nom_bus"));
        mat_col_bus.setCellValueFactory(new PropertyValueFactory<bus, String>("immatriculation"));
        ch_col_bus.setCellValueFactory(new PropertyValueFactory<bus, Integer>("id_ch"));
        cat_col_bus.setCellValueFactory(new PropertyValueFactory<bus, Integer>("num_cb"));
        table_view.setItems(list);
        methods.message("infos", "data has been added successfully !");
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
    void supprimer_bus_click(ActionEvent event) throws SQLException {
        int index = table_view.getSelectionModel().getSelectedIndex();
        if(index<=-1) {
            return;
        }
        bus b1 =new bus(String.valueOf(id_col_bus.getCellData(index)));
        b1.supprime_bus();
        list = b1.getAll_bus();
        txt_lib_bus.setText(lib_col_bus.getCellData(index));
        txt_mat_bus.setText(mat_col_bus.getCellData(index));
        txt_ch_bus.setText(String.valueOf(ch_col_bus.getCellData(index)));
        txt_cat_bus.setText(String.valueOf(cat_col_bus.getCellData(index)));
        table_view.setItems(list);
        methods.message("infos", "data has been deleted successfully !");
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


    public void initializee(ActionEvent actionEvent) {
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

