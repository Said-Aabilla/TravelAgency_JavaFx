package sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.connectionDB;

public class bus {
	private String id_bus;
	private String image_bus;
	private String nom_bus;
	private String immatriculation;
	private String id_ch;
	private String num_cb;

	public bus() {
		super();
	}
	public bus(String id_bus) {

		this.id_bus = id_bus;
	}
	public bus(String id_bus, String image_bus, String nom_bus, String immatriculation, String id_ch, String num_cb) {

		this.id_bus = id_bus;
		this.image_bus = image_bus;
		this.nom_bus = nom_bus;
		this.immatriculation = immatriculation;
		this.id_ch = id_ch;
		this.num_cb = num_cb;
	}

	public String getId_bus() {
		return id_bus;
	}
	public void setId_bus(String id_bus) {
		this.id_bus = id_bus;
	}
	public String getImage_bus() {
		return image_bus;
	}
	public void setImage_bus(String image_bus) {
		this.image_bus = image_bus;
	}
	public String getNom_bus() {
		return nom_bus;
	}
	public void setNom_bus(String nom_bus) {
		this.nom_bus = nom_bus;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getId_ch() {
		return id_ch;
	}
	public String getNum_cb() {
		return num_cb;
	}
	public void setNum_cb(String num_cb) {
		this.num_cb = num_cb;
	}

	public ObservableList<bus> getAll_bus() throws SQLException {
		connectionDB con=new connectionDB();
		Connection connection=con.getConnection();
		String sql = "select* from bus";
		Statement stm=connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		ObservableList<bus> list = FXCollections.observableArrayList();
		while(rs.next()) {
			list.add(new bus(rs.getString("id_bus"),"default",rs.getString("nom_bus"),rs.getString("immatriculation"),
					rs.getString("id_ch"),rs.getString("num_cb")));
		}
		return list;
	}
	public ObservableList<bus> get_bus(String text ) throws SQLException{
		connectionDB con=new connectionDB();
		Connection connection=con.getConnection();
		String sql = "select * from bus  where nom_bus = '"+text+"'";
		Statement stm=connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		ObservableList<bus> list = FXCollections.observableArrayList();
		while(rs.next()) {
			list.add(new bus(rs.getString("id_bus"),"default",rs.getString("nom_bus"),rs.getString("immatriculation"),
					rs.getString("id_ch"),rs.getString("num_cb")));
		}
		return list;
	}

	public void ajouter_bus() throws SQLException {
		connectionDB con=new connectionDB();
		Connection connection=con.getConnection();
		String sql="INSERT INTO bus (image_bus, nom_bus, immatriculation, id_ch, num_cb) VALUES ('"+this.image_bus+"', '"+this.nom_bus+"','"+this.immatriculation+"',"+this.id_ch+","+this.num_cb+")";
		Statement stm=connection.createStatement();
		stm.executeUpdate(sql);
	}
	public void  modifier_bus() throws SQLException {
		connectionDB con=new connectionDB();
		Connection connection=con.getConnection();
		String sql="update bus set nom_bus='"+this.nom_bus+"',immatriculation='"+this.immatriculation+"',id_ch="+this.id_ch+",num_cb="+this.num_cb+" where id_bus="+this.id_bus;
		Statement stm=connection.createStatement();
		stm.executeUpdate(sql);
	}
	public void  supprime_bus() throws SQLException {
		connectionDB con=new connectionDB();
		Connection connection=con.getConnection();
		Statement stm=connection.createStatement();
		String sql1="update place_bus set id_bus=null where id_bus= "+this.id_bus;
		stm.executeUpdate(sql1);
		String sql2 = "delete from bus  where id_bus = "+this.id_bus;
		stm.executeUpdate(sql2);
	}


}
