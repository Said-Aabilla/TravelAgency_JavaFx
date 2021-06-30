package sample.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import sample.util.connectionDB;

public class categories_bus {
private int num_cb;
private String libelle_cb;
private int capacite_cb;
private double price;

public categories_bus(int num_cb) {
	this.num_cb = num_cb;
}

    public categories_bus(int num_cb, String libelle_cb, int capacite_cb, double price) {
        this.num_cb = num_cb;
        this.libelle_cb = libelle_cb;
        this.capacite_cb = capacite_cb;
        this.price = price;
    }

    public categories_bus(int num_cb, String libelle_cb, int capacite_cb) {

	this.num_cb = num_cb;
	this.libelle_cb = libelle_cb;
	this.capacite_cb = capacite_cb;
}

    public categories_bus() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum_cb() {

	return num_cb;
}

public void setNum_cb(int num_cb) {
	this.num_cb = num_cb;
}

public String getLibelle_cb() {
	return libelle_cb;
}

public void setLibelle_cb(String libelle_cb) {
	this.libelle_cb = libelle_cb;
}

public int getCapacite_cb() {
	return capacite_cb;
}

public void setCapacite_cb(int capacite_cb) {
	this.capacite_cb = capacite_cb;
}
  public void ajouter_cb() throws SQLException {
	  connectionDB con=new connectionDB();
      Connection connection=con.getConnection();
     String sql="INSERT INTO categories_bus (libelle_cb, capecité_cb) VALUES ('"+this.libelle_cb+"', "+this.capacite_cb+")";

      Statement stm=connection.createStatement();
      stm.executeUpdate(sql);
  }
  public void  modifier_cb() throws SQLException {
	  connectionDB con=new connectionDB();
      Connection connection=con.getConnection();
      String sql="update categories_bus set libelle_cb='"+this.libelle_cb+"', capacité_cb="+this.capacite_cb+" where num_cb="+this.num_cb;

      Statement stm=connection.createStatement();
      stm.executeUpdate(sql);
  }
  public void  supprime_cb() throws SQLException {
	  connectionDB con=new connectionDB();
      Connection connection=con.getConnection();
      Statement stm=connection.createStatement();
      String sql1="update bus set num_cb=null where num_cb="+this.num_cb;
      stm.executeUpdate(sql1);
      String sql2 = "delete from categories_bus  where num_cb ="+this.num_cb;
      stm.executeUpdate(sql2);
  }

}
