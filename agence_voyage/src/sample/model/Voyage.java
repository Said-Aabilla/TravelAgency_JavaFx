package sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.connectionDB;
import sample.util.voyage_info;

public class Voyage {

    private int id_voyage;
    private String libelle_voyage;
    private String date_deb;
    private String date_fin;
    private String heure_debut;
    private String heure_fin;
    private int id_bus;
    private String ville_depart;
    private String ville_arrive;
    public static ObservableList<voyage_info> list ;

    public int getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = id_voyage;
    }

    public String getLibelle_voyage() {
        return libelle_voyage;
    }

    public void setLibelle_voyage(String libelle_voyage) {
        this.libelle_voyage = libelle_voyage;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }


    public Voyage(int id_voyage, String libelle_voyage, String date_deb, String date_fin, String heure_debut,
                  String heure_fin, int id_bus, String ville_depart, String ville_arrive) {
        super();
        this.id_voyage = id_voyage;
        this.libelle_voyage = libelle_voyage;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.id_bus = id_bus;

    }

    public Voyage() {
        super();
    }


    public  void get_voyage(String villeD, String villeA, String date) throws SQLException, ClassNotFoundException {
        connectionDB conn = new connectionDB();
        Connection connection = conn.getConnection();

        String sql = "select id_voyage,libelle_voyage,date_debut,date_fin,heure_debut,heure_fin,voyages.id_bus,ville_depart,ville_arrive from  voyages,bus where voyages.id_bus=bus.id_bus and ( (ville_depart like '%" + villeD + "%' and  ville_arrive like '%" + villeA + "%' ) or date_debut like '%" + date + "%')";
        Statement stm = connection.createStatement();
        ResultSet res = stm.executeQuery(sql);

        ObservableList<voyage_info> liste = FXCollections.observableArrayList();
        while (res.next()) {
            liste.add(new voyage_info(res.getString("id_voyage"), res.getString("libelle_voyage"), res.getString("date_debut"),
                    res.getString("date_fin"), res.getString("heure_debut"), res.getString("heure_fin"), res.getString("id_bus"), res.getString("ville_depart"),
                    res.getString("ville_arrive")));
        }

        this.list = liste;

    }


    /* chercherDate d'un voyage */
    public ArrayList<Voyage> chercherDate(String date) throws SQLException {
        connectionDB con = new connectionDB();
        Connection connection = con.getConnection();

        String sql = "select * from  voyage where date_deb  =" + date + " order by heure_debut asc";
        Statement stm = connection.createStatement();
        ResultSet res = stm.executeQuery(sql);
        ArrayList<Voyage> mesvoyages = new ArrayList<Voyage>();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        while (res.next()) {
            //String date_deb = String.parse(res.getString("date_deb"), formatter);
            //String date_fin = String.parse(res.getString("date_fin"), formatter);
            //String heure_debut = String.parse(res.getString("heure_debut"));
            //String heure_fin = String.parse(res.getString("heure_fin"));
            String date_deb = res.getString("date_deb");
            String date_fin = res.getString("date_fin");
            String ville_depart = res.getString("ville_depart");
            String ville_arrive = res.getString("ville_arrive");

            mesvoyages.add(new Voyage(res.getInt("id_voyage"), res.getString("libelle_voyage"), date_deb,
                    date_fin, heure_debut, heure_fin,
                    res.getInt("id_bus"), ville_depart, ville_arrive));

        }
        return mesvoyages;
    }


    //endak tnssa hadi, zid liha string blast localdate
	/* Reserver Un voyage
	public void reserverVoyage(Voyage v, Client c, place_bus p ,int nbr_places) throws SQLException {
		connectionDB con = new connectionDB();
		Connection connection = con.getConnection();
		String date_reservation = String.now();
		String sql1 = "select * from  place_bus where id_bus  =" + p.getId_bus();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(sql1);
		ResultSet result = stmt.executeQuery(sql1);
		int id_place_bus = 0;
		while (result.next()) {
			id_place_bus = result.getInt("id_pb");
		}
		String sql = "INSERT INTO `reservation` (`nbr_places`, `date_res`, `id_client`,`id_voyage`,`place_bus`) VALUES ( "
				+ nbr_places + "," + date_reservation + "," + c.getId_client() + " ," + v.getId_voyage() + " ," +id_place_bus+ ")";
		Statement stm = connection.createStatement();
		stm.executeUpdate(sql);
	}
*/






/*
	//Select * from Voyages operation
	public static ObservableList<Voyage> getVoyageList() throws SQLException, ClassNotFoundException {

		//Declare a observable List which comprises of Voyage objects
		ObservableList<Voyage> VoyList = FXCollections.observableArrayList();
		connectionDB con = new connectionDB();
		Connection connection = con.getConnection();
		String sql = "SELECT * FROM voyages";
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			String date_deb = res.getString("date_debut");
			String date_fin =  res.getString("date_fin");
			String heure_debut =  res.getString("heure_debut");
			String heure_fin =  res.getString("heure_fin");
			Voyage Voy = new Voyage();
			Voy.setId_voyage(res.getInt("id_voyage"));
			Voy.setLibelle_voyage(res.getString("libelle_voyage"));
			Voy.setDate_deb(date_deb);
			Voy.setDate_fin(date_fin);
			Voy.setHeure_debut(heure_debut);
			Voy.setHeure_fin(heure_fin);
			//Voy.setId_bus(res.getInt("id_bus"));
			Voy.setId_bus(12);
			//Voy.setId_res(res.getInt("id_res"));


			//Add Voyage to the ObservableList
			VoyList.add(Voy);
		}
		//return VoyList (ObservableList of Voyages)
		return VoyList;
	}

*/


}
