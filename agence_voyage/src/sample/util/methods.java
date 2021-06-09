package sample.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class methods {
	public static void message(String title, Alert.AlertType type,String header, String msg) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(msg);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	public static void message(String title, Alert.AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	public static void message(String title, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	public static boolean length_test(String text, int nbr_max){
		if(text.length() > nbr_max) return true;
		else return false;
	}
}
