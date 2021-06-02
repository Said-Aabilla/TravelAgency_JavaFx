package sample.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import sample.util.connectionDB;

public class categories_places {

	private int num_cp;
	private String libelle_cp;
	private int prix_cp;
	public categories_places(int num_cp) {
		this.num_cp = num_cp;
	}
	public categories_places(int num_cp, String libelle_cp, int prix_cp) {
		this.num_cp = num_cp;
		this.libelle_cp = libelle_cp;
		this.prix_cp = prix_cp;
	}
	
	public int getNum_cp() {
		return num_cp;
	}
	public void setNum_cp(int num_cp) {
		this.num_cp = num_cp;
	}
	public String getLibelle_cp() {
		return libelle_cp;
	}
	public void setLibelle_cp(String libelle_cp) {
		this.libelle_cp = libelle_cp;
	}
	public int getPrix_cp() {
		return prix_cp;
	}
	public void setPrix_cp(int prix_cp) {
		this.prix_cp = prix_cp;
	}
	
	 public void ajouter_cp() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	     String sql="INSERT INTO categories_places (libelle_cp, prix_cp) VALUES ('"+this.libelle_cp+"', "+this.prix_cp+")";
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public void  modifier_cp() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql="update categories_places set libelle_cp='"+this.libelle_cp+"', prix_cp="+this.prix_cp+" where num_cp="+this.num_cp;
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public void  supprime_cp() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      Statement stm=connection.createStatement();
	      String sql1="update place_bus set num_cp=null where num_cp="+this.num_cp;
	      stm.executeUpdate(sql1);
	      String sql2 = "delete from categories_places  where num_cp ="+this.num_cp;
	      stm.executeUpdate(sql2);
	  }



}
