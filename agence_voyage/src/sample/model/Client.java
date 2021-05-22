package sample.model;

public class Client extends User  {
	 
	private int id_client;
	private String nom_client;
	private String prenom_client;
	private String adresse_client;
	private String tel_client;
	private int cp_client;
	private int id_user;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(int id_user, String email_user, String password_user) {
		super(id_user, email_user, password_user);
	}


	public Client(int id_user, String email_user, String password_user, int id_client, String nom_client,
			String prenom_client, String adresse_client, String tel_client, int cp_client, int id_user2) {
		super(id_user, email_user, password_user);
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.adresse_client = adresse_client;
		this.tel_client = tel_client;
		this.cp_client = cp_client;
		id_user = id_user2;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public String getNom_client() {
		return nom_client;
	}


	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}


	public String getPrenom_client() {
		return prenom_client;
	}


	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}


	public String getAdresse_client() {
		return adresse_client;
	}


	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}


	public String getTel_client() {
		return tel_client;
	}


	public void setTel_client(String tel_client) {
		this.tel_client = tel_client;
	}


	public int getCp_client() {
		return cp_client;
	}


	public void setCp_client(int cp_client) {
		this.cp_client = cp_client;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	
 



}
