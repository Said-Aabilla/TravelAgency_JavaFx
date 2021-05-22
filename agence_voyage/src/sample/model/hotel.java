package sample.model;

public class hotel {

	private int id_hotel;
	private String short_description;
	private String description;
	private String adressse;
	private String prix_range;
	private int num_ville;
	public hotel() {
	}
	public hotel(int id_hotel, String short_description, String description, String adressse, String prix_range,
			int num_ville) {
		this.id_hotel = id_hotel;
		this.short_description = short_description;
		this.description = description;
		this.adressse = adressse;
		this.prix_range = prix_range;
		this.num_ville = num_ville;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdressse() {
		return adressse;
	}
	public void setAdressse(String adressse) {
		this.adressse = adressse;
	}
	public String getPrix_range() {
		return prix_range;
	}
	public void setPrix_range(String prix_range) {
		this.prix_range = prix_range;
	}
	public int getNum_ville() {
		return num_ville;
	}
	public void setNum_ville(int num_ville) {
		this.num_ville = num_ville;
	}
	
	

}
