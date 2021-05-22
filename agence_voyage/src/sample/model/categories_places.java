package sample.model;

public class categories_places {

	private int num_cp;
	private String libelle_cp;
	private int prix_cp;
	
	public categories_places() {
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
	
	



}
