package sample.model;
import sample.util.connectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class reservation {

	private int No_res;
	private int nbr_places;
	private LocalDate date_res;
	private int id_client;
	private int id_voyage;
	private int place_bus;
	public reservation() {
	}

	public reservation(int no_res, int nbr_places, LocalDate date_res, int id_client, int id_voyage, int place_bus) {
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

	public LocalDate getDate_res() {
		return date_res;
	}

	public void setDate_res(LocalDate date_res) {
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

	public void setPlace_bus(int place_bus) {
		this.place_bus = place_bus;
	}

	// consulter reservation
	public ArrayList<reservation> consulterReservation(int id) throws SQLException {
		connectionDB con = new connectionDB();
		Connection connection = con.getConnection();
		String sql = "select * from  reservation  where id_client =" + id;
		Statement stm = connection.createStatement();
		ResultSet result = stm.executeQuery(sql);
		ArrayList<reservation> myreservations = new ArrayList<reservation>();
		while (result.next()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date_res = LocalDate.parse(result.getString("date_res"), formatter);
			myreservations.add(new reservation(result.getInt("no_res"),result.getInt("nbr_places") ,
					date_res, result.getInt("id_client"), result.getInt("id_voyage"),
					result.getInt("place_bus")));
		}
		return myreservations;
	}


}
