package sample.model;

import sample.util.connectionDB;

import java.sql.*;
import java.util.ArrayList;

public class hotel {

	private int id_hotel;
	private Blob image_hotel;
	private String short_description;
	private String description;
	private String adressse;
	private String prix_range;
	private int num_ville;
	public hotel() {
	}
	public hotel(int id_hotel,Blob image_hotel, String short_description, String description, String adressse, String prix_range,
			int num_ville) {
		this.id_hotel = id_hotel;
		this.image_hotel=image_hotel;
		this.short_description = short_description;
		this.description = description;
		this.adressse = adressse;
		this.prix_range = prix_range;
		this.num_ville = num_ville;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdressse() {
		return adressse;
	}
	public void setAdressse(String adressse) {
		this.adressse = adressse;
	}
	public String getPrix_range() {
		return prix_range;
	}
	public void setPrix_range(String prix_range) {
		this.prix_range = prix_range;
	}
	public int getNum_ville() {
		return num_ville;
	}
	public void setNum_ville(int num_ville) {
		this.num_ville = num_ville;
	}
	public Blob getImage_hotel() {
		return image_hotel;
	}
	public void setImage_hotel(Blob image_hotel) {
		this.image_hotel = image_hotel;
	}

	/* chercherHotel */
	public ArrayList<hotel> chercherHotel(String ville) throws SQLException {
		connectionDB con = new connectionDB();
		Connection connection = con.getConnection();
		String sql = "select * from  ville  where nom_ville =" + ville;
		Statement stm = connection.createStatement();
		ResultSet res = stm.executeQuery(sql);
		int id = 0 ;
		while (res.next()) {
			int id_ville = Integer.valueOf(res.getString("num_ville"));
			id=id_ville;
		}
		//chercher l'hotel d'apres num ville:
		String sqlreq = "select * from  hotel where num_ville =" + id;
		Statement stmnt = connection.createStatement();
		ResultSet result = stm.executeQuery(sql);
		ArrayList<hotel> myhotels = new ArrayList<hotel>();
		while (result.next()) {

					myhotels.add(new hotel(result.getInt("id_hotel"),result.getBlob("image_hotel"),res.getString("short_description"),
					res.getString("description"),res.getString("adressse"),res.getString("prix_range"),
					Integer.valueOf(res.getString("num_ville"))) ); }
		return myhotels;
	}



}
