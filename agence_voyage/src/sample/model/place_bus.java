package sample.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import sample.util.connectionDB;

public class place_bus {

	private int id_pb;
	private int num_cp;
	private int id_bus;
	public place_bus() {
	}
	public place_bus(int id_pb) {
		this.id_pb = id_pb;
	}
	public place_bus(int id_pb, int num_cp, int id_bus) {
		this.id_pb = id_pb;
		this.num_cp = num_cp;
		this.id_bus = id_bus;
	}
	public int getId_pb() {
		return id_pb;
	}
	public void setId_pb(int id_pb) {
		this.id_pb = id_pb;
	}
	public int getNum_cp() {
		return num_cp;
	}
	public void setNum_cp(int num_cp) {
		this.num_cp = num_cp;
	}
	public int getId_bus() {
		return id_bus;
	}
	public void setId_bus(int id_bus) {
		this.id_bus = id_bus;
	}
	 public void ajouter_pb() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	     String sql="INSERT INTO place_bus (num_cp, id_bus) VALUES ("+this.num_cp+", "+this.id_bus+")";
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public void  modifier_pb() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      String sql="update place_bus set num_cp="+this.num_cp+", id_bus="+this.id_bus+" where id_pb="+this.id_pb;
	      Statement stm=connection.createStatement();
	      stm.executeUpdate(sql);
	  }
	  public void  supprime_pb() throws SQLException {
		  connectionDB con=new connectionDB();
	      Connection connection=con.getConnection();
	      Statement stm=connection.createStatement();
	      String sql = "delete from place_bus  where id_pb ="+this.id_pb;
	      stm.executeUpdate(sql);
	  }
	
}
