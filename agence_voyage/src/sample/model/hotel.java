package sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.connectionDB;
import sample.util.hotel_infos;

public class hotel {

	private int id_hotel;
	private String image_hotel;
	private String short_description;
	private String description;
	private String adresse;
	private String prix_range;
	private int num_ville;
	public hotel(int id_hotel ) {
		this.id_hotel = id_hotel;
	}
	public hotel(int id_hotel , String image_hotel, String short_description, String description, String adresse, String prix_range,
			int num_ville) {
		this.id_hotel = id_hotel;
		this.image_hotel=image_hotel;
		this.short_description = short_description;
		this.description = description;
		this.adresse = adresse;
		this.prix_range = prix_range;
		this.num_ville = num_ville;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public String getImage_hotel() {
		return image_hotel;
	}
	public void setImage_hotel(String image_hotel) {
		this.image_hotel = image_hotel;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	
	public void ajouter_hotel(String ville) throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      Statement stm=connection.createStatement();
	      String sql2 = "insert into ville ( nom_ville,cp_ville) value('"+ville+"', null)";
	      stm.executeUpdate(sql2);
	      String sql3 = "select num_ville from ville where nom_ville='"+ville+"'";
	      ResultSet rs = stm.executeQuery(sql3);
	      while(rs.next()) {
	    	  this.num_ville = Integer.valueOf(rs.getString("num_ville"));
	      }
	     String sql="INSERT INTO hotel (image_hotel, short_description, description, adresse,prix_range,num_ville) "
	     		+ "VALUES ('"+this.image_hotel+"', '"+this.short_description+"','"+this.description+"','"+this.adresse+"','"+this.prix_range+"',"+this.num_ville+")";
	      stm.executeUpdate(sql);
	  }
	  public void  modifier_hotel(String ville) throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      Statement stm=connection.createStatement();
	      String sql2 = "insert into ville ( nom_ville,cp_ville) value('"+ville+"', null)";
	      stm.executeUpdate(sql2);
	      String sql3 = "select num_ville from ville where nom_ville='"+ville+"'";
	      ResultSet rs = stm.executeQuery(sql3);
	      while(rs.next()) {
	    	  this.num_ville = Integer.valueOf(rs.getString("num_ville"));
	      }
	      String sql="update hotel set image_hotel='"+this.image_hotel+"', short_description='"+this.short_description+"',descrip"
	      		+ "tion='"+this.description+"',adresse='"+this.adresse+"',prix_range='"+this.prix_range+"',num_ville="+this.num_ville+" where id_hotel="+this.id_hotel;
	      stm.executeUpdate(sql);
	  }
	  public void  supprime_hotel() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql = "delete from hotel  where id_hotel ="+this.id_hotel;
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public ObservableList<hotel_infos> get_hotel(String text) throws SQLException{
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql = "select id_hotel,short_description, description, adresse,prix_range,nom_ville from hotel,ville  where hotel.num_ville =ville.num_ville and(id_hotel= "+this.id_hotel+" or short_description like '%"+text+"%' or description like '%"+text+"%' or adresse like '%"+text+"%' or nom_ville like '%"+text+"%' )";
	      Statement stm=connection.createStatement();
	      ResultSet rs = stm.executeQuery(sql);
	      ObservableList<hotel_infos> list = FXCollections.observableArrayList();
	      while(rs.next()) {
	    	  list.add(new hotel_infos(rs.getString("id_hotel"),rs.getString("short_description"), rs.getString("description"), rs.getString("adresse"), rs.getString("prix_range"), rs.getString("nom_ville")));
	      }
		  return list;
	  }
	  public ObservableList<hotel_infos> getAll_hotel() throws SQLException{
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql = "select id_hotel,short_description, description, adresse,prix_range,nom_ville from hotel,ville  where hotel.num_ville =ville.num_ville";
	      Statement stm=connection.createStatement();
	      ResultSet rs = stm.executeQuery(sql);
	      ObservableList<hotel_infos> list = FXCollections.observableArrayList();
	      while(rs.next()) {
	    	  list.add(new hotel_infos(rs.getString("id_hotel"),rs.getString("short_description"), rs.getString("description"), rs.getString("adresse"), rs.getString("prix_range"), rs.getString("nom_ville")));
	      }
		  return list;
	  }
	public hotel() {
		super();
	}


}
