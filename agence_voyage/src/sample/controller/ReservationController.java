package sample.controller;


	import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
	import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.model.Client;
import sample.model.User;
import sample.util.DatabaseHandler;
	import sample.util.GeneratePDF;
	import sample.util.Mail;

public class ReservationController implements Initializable {

	    @FXML
	    private Label dateDep;

	    @FXML
	    private Label NbrPlace;

	    @FXML
	    private Label villeDep;

	    @FXML
	    private Label villeArr;

	    @FXML
	    private Label Categorie;

	    @FXML
	    private Label Prenom;

	    @FXML
	    private Label Nom;

	    @FXML
	    private Label CIN;

	    @FXML
	    private Label Price;
	    
	    @FXML
	    private Label nbr;

	    @FXML
	    private Button Confirmer;
	    
	    @FXML
	    private Button annuler;
	    @FXML
	    private AnchorPane window;


	    @FXML
	    void ConfirmerReservation(ActionEvent event) throws Exception {
			GeneratePDF.generatePDF(150,dateDep.getText(),"",villeDep.getText(),villeArr.getText());
			AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/BilletSent.fxml"));
			window.getChildren().setAll(obj);
	    }

	    @FXML
	    void annuler(ActionEvent event) throws IOException {
	    	AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/ClientVoyage.fxml"));
			window.getChildren().setAll(obj);
	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
		    
		    Client cl = new Client ();
		    cl = DatabaseHandler.clientprofile(User.us);
		    Prenom.setText(cl.getPrenom_client());
		    Nom.setText(cl.getNom_client());
		    CIN.setText(cl.getCin());
		    dateDep.setText(ClientController.voy.getDate_deb());    
		    villeDep.setText(ClientController.voy.getVille_depart()); 
		    villeArr.setText(ClientController.voy.getVille_arrive()); 
		    Categorie.setText("Confort"); 
		    Price.setText("150 DH"); 
		    nbr.setText("10");
		}
        
		
	}
