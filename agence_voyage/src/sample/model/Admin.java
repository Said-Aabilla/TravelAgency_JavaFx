package sample.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import sample.util.connectionDB;

public class Admin extends User {

	private int id_admin;
	private String matricul;
	private Blob image;
	private String nom_admin;
	private String prenom_admin;
	private int id_user;

	public Admin() {
		super();
	}

	public Admin(int id_user, String email_user, String password_user, int id_admin, String matricul, Blob image, String nom_admin, String prenom_admin, int id_user1) {
		super(id_user, email_user, password_user);
		this.id_admin = id_admin;
		this.matricul = matricul;
		this.image = image;
		this.nom_admin = nom_admin;
		this.prenom_admin = prenom_admin;
		this.id_user = id_user1;
	}

	public int getId_admin() {
		return id_admin;
	}

	public String getMatricul() {
		return matricul;
	}

	public Blob getImage() {
		return image;
	}

	public String getNom_admin() {
		return nom_admin;
	}

	public String getPrenom_admin() {
		return prenom_admin;
	}

	@Override
	public int getId_user() {
		return id_user;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}

	public void setPrenom_admin(String prenom_admin) {
		this.prenom_admin = prenom_admin;
	}

	@Override
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}
