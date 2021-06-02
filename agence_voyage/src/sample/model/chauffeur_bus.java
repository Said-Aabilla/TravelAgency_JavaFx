package sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.connectionDB;

public class chauffeur_bus {

	private int id_ch;
	private String image_ch;
	private String nom_ch;
	private String prenom_ch;
	private String tel_ch;
	
	public chauffeur_bus() {
		super();
	}
	public chauffeur_bus(int id_ch) {
		super();
		this.id_ch = id_ch;
	}
	public chauffeur_bus(int id_ch, String image_ch, String nom_ch, String prenom_ch, String tel_ch) {
		this.id_ch = id_ch;
		this.image_ch = image_ch;
		this.nom_ch = nom_ch;
		this.prenom_ch = prenom_ch;
		this.tel_ch = tel_ch;
	}
	public int getId_ch() {
		return id_ch;
	}
	public void setId_ch(int id_ch) {
		this.id_ch = id_ch;
	}
	public String getImage_ch() {
		return image_ch;
	}
	public void setImage_ch(String image_ch) {
		this.image_ch = image_ch;
	}
	public String getNom_ch() {
		return nom_ch;
	}
	public void setNom_ch(String nom_ch) {
		this.nom_ch = nom_ch;
	}
	public String getPrenom_ch() {
		return prenom_ch;
	}
	public void setPrenom_ch(String prenom_ch) {
		this.prenom_ch = prenom_ch;
	}
	public String getTel_ch() {
		return tel_ch;
	}
	public void setTel_ch(String tel_ch) {
		this.tel_ch = tel_ch;
	}
	 public ObservableList<chauffeur_bus> getAll_chauffeur() throws SQLException {
	    	connectionDB con=new connectionDB();
		      Connection connection=con.getConnection();
		      String sql = "select* from chauffeur_bus";
		      Statement stm=connection.createStatement();
		      ResultSet rs = stm.executeQuery(sql);
		      ObservableList<chauffeur_bus> list = FXCollections.observableArrayList();
		      while(rs.next()) {
		    	  list.add(new chauffeur_bus(Integer.valueOf(rs.getString("id_ch")),"default",rs.getString("nom_ch"),rs.getString("prenom_ch"),
		    			  rs.getString("tel_ch")));
		    	  }
		      return list;
	    }
	 public ObservableList<chauffeur_bus> get_chauffeur(String text ) throws SQLException{
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql = "select * from chauffeur_bus  where nom_ch like'%"+text+"%' or prenom_ch like '%"+text+"%'or tel_ch like '%"+text+"%'";
	      Statement stm=connection.createStatement();
	      ResultSet rs = stm.executeQuery(sql);
	      ObservableList<chauffeur_bus> list = FXCollections.observableArrayList();
	      while(rs.next()) {
	    	  list.add(new chauffeur_bus(Integer.valueOf(rs.getString("id_ch")),"default",rs.getString("nom_ch"),rs.getString("prenom_ch"),
	    			  rs.getString("tel_ch")));
	    	  }
		  return list;
	  }
	 public void ajouter_ch() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	     String sql="INSERT INTO chauffeur_bus (image_ch, nom_ch, prenom_ch, tel_ch) VALUES ('"+this.image_ch+"', '"+this.nom_ch+"', '"+this.prenom_ch+"', '"+this.tel_ch+"')";
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public void  modifier_ch() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql="update chauffeur_bus set image_ch='"+this.image_ch+"', nom_ch='"+this.nom_ch+"', prenom_ch='"+this.prenom_ch+"', tel_ch='"+this.tel_ch+"' where id_ch="+this.id_ch;
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public void  supprime_ch() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      Statement stm=connection.createStatement();
	      String sql1="update bus set id_ch=null where id_ch="+this.id_ch;
	      stm.executeUpdate(sql1);
	      String sql2 = "delete from chauffeur_bus  where id_ch ="+this.id_ch;
	      stm.executeUpdate(sql2);
	  }
	
	
}
