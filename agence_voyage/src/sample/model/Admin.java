package sample.model;

public class Admin extends User {

	private int id_admin;
	private String nom_admin;
	private String prenom_admin;
	private int id_user;

	public Admin() {
		super();
	}

	
	public Admin(int id_user, String email_user, String password_user) {
		super(id_user, email_user, password_user);
		// TODO Auto-generated constructor stub
	}


	public Admin(int id_user, String email_user, String password_user, int id_admin, String nom_admin,
			String prenom_admin, int id_user2) {
		super(id_user, email_user, password_user);
		this.id_admin = id_admin;
		this.nom_admin = nom_admin;
		this.prenom_admin = prenom_admin;
		id_user = id_user2;
	}


	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getNom_admin() {
		return nom_admin;
	}

	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}

	public String getPrenom_admin() {
		return prenom_admin;
	}

	public void setPrenom_admin(String prenom_admin) {
		this.prenom_admin = prenom_admin;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

}
