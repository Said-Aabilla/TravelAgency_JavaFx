package sample.controller;


	import java.io.IOException;
import java.net.URL;
	import java.sql.SQLException;
	import java.util.ResourceBundle;

	import com.jfoenix.controls.JFXBadge;
	import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
	import sample.model.*;
	import sample.util.DatabaseHandler;

	import sample.util.GeneratePDF;
	import sample.util.Mail;

public class ReservationController implements Initializable {

	    @FXML
	    private Label dateDep;

	@FXML
	private Label villedep;

	@FXML
	private Label villeArr;

	    @FXML
	    private Label Categorie;

	    @FXML
    	private Label vdep;

	    @FXML
	    private Label Prenom;

	    @FXML
	    private Label Nom;

	    @FXML
	    private Label CIN;

	    @FXML
	    private Label Price;
	    
	    @FXML

	    private Label hour;



	    @FXML
	    private Button Confirmer;
	    
	    @FXML
	    private Button annuler;
	    @FXML
	    private AnchorPane window;


	    @FXML
	    void ConfirmerReservation(ActionEvent event) throws Exception {
			GeneratePDF.generatePDF(Price.getText(),dateDep.getText(),hour.getText(),vdep.getText(),villeArr.getText());
			Alert a = new Alert(Alert.AlertType.NONE);
			a.setAlertType(Alert.AlertType.INFORMATION);
			a.setContentText("Merci pour votre reservation, veuiller verifier votre boite mail pour telecharger le billet.");
			// show the dialog
			a.show();
			Mail.sendMail(User.em);
			DatabaseHandler.insertreservation( Voyage.id,Integer.toString(User.us));
			AnchorPane obj = FXMLLoader.load(getClass().getResource("../view/Mesreservations.fxml"));
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

		    categories_bus category = new categories_bus();
		    Client cl = DatabaseHandler.clientprofile(User.us);
			try {
				category = DatabaseHandler.getcategorie(ClientController.voy.getId_bus());
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Prenom.setText(cl.getPrenom_client());
		    Nom.setText(cl.getNom_client());
		    CIN.setText(cl.getCin());
		    dateDep.setText(ClientController.voy.getDate_deb());
			System.out.println(ClientController.voy.getVille_depart());

			vdep.setText(ClientController.voy.getVille_depart());

			//villedep.setText(ClientController.ville);
			villeArr.setText(ClientController.voy.getVille_arrive());
		    Categorie.setText(category.getLibelle_cb());
		    Price.setText("Prix à payer :"+category.getPrice()+"DH");
			hour.setText(ClientController.voy.getHeure_debut());
			System.out.println(hour.getText());
			//nbr.setText();

		}
        
		
	}
