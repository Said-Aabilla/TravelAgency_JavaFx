package sample.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import sample.util.connectionDB;
public class Ville {

	private int num_ville;
	private String nom_ville;
	private int cp_ville;

	public Ville(int num_ville, String nom_ville, int cp_ville) {
		this.num_ville = num_ville;
		this.nom_ville = nom_ville;
		this.cp_ville = cp_ville;
	}

	public int getNum_ville() {
		return num_ville;
	}
	public void setNum_ville(int num_ville) {
		this.num_ville = num_ville;
	}
	public String getNom_ville() {
		return nom_ville;
	}
	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}
	public int getCp_ville() {
		return cp_ville;
	}
	public void setCp_ville(int cp_ville) {
		this.cp_ville = cp_ville;
	}


	/* chercherVille */
	public Ville chercherVille(String ville) throws SQLException {
		connectionDB con = new connectionDB();
		Connection connection = con.getConnection();
		String sql = "select * from  ville  where nom_ville =" + ville;
		Statement stm = connection.createStatement();
		ResultSet res = stm.executeQuery(sql);
		Ville vl = null;
		while (res.next()) {
			vl = new Ville(Integer.valueOf(res.getString("num_ville")), res.getString("nom_ville"),
					Integer.valueOf(res.getString("cp_ville")));
		}
		return vl;
	}

}
