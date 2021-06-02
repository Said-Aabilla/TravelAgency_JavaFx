package sample.model;

public class chauffeur_bus {

	private int id_ch;
	private String image_ch;
	private String nom_ch;
	private String prenom_ch;
	private String tel_ch;
	public chauffeur_bus() {
	}
	public chauffeur_bus(int id_ch,String image_ch, String nom_ch, String prenom_ch, String tel_ch) {
		this.id_ch = id_ch;
		this.image_ch=image_ch;
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
	public String getImage_ch() {
		return image_ch;
	}
	public void setImage_ch(String image_ch) {
		this.image_ch = image_ch;
	}
	
	
}
