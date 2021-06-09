package sample.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.connectionDB;
import sample.util.voyage_info;

import java.sql.*;
import java.time.*;

public class reservation {

	private int No_res;
	private int nbr_places;
	private String date_res;
	private int id_client;
	private int id_voyage;
	private int place_bus;
	public reservation() {
	}

	public reservation(int no_res, int nbr_places, String date_res, int id_client, int id_voyage, int place_bus) {
		No_res = no_res;
		this.nbr_places = nbr_places;
		this.date_res = date_res;
		this.id_client = id_client;
		this.id_voyage = id_voyage;
		this.place_bus = place_bus;
	}

	public int getNo_res() {
		return No_res;
	}

	public void setNo_res(int no_res) {
		No_res = no_res;
	}

	public int getNbr_places() {
		return nbr_places;
	}

	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}

	public String getDate_res() {
		return date_res;
	}

	public void setDate_res(String date_res) {
		this.date_res = date_res;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}

	public int getPlace_bus() {
		return place_bus;
	}

	public reservation(int No_res, String date_res) {
		this.No_res = No_res;
		this.date_res = date_res;
	}

	/* Reserver Un voyage */
	public void reserverVoyage(Voyage v, Client c, place_bus p ,int nbr_places) throws SQLException {
		connectionDB con = new connectionDB();
		Connection connection = con.getConnection();

	}


	public void setPlace_bus(int place_bus) {
		this.place_bus = place_bus;
	}




}
