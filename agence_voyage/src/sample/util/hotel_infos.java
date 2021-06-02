package sample.util;

public class hotel_infos {
	private String id;
	private String short_description;
	private String description;
	private String adresse;
	private String Prix_range;
	private String ville;
	public String getShort_description() {
		return short_description;
	}

	public hotel_infos(String id, String short_description, String description, String adresse,String prix_range, String ville) {
		super();
		this.id = id;
		this.short_description = short_description;
		this.description = description;
		this.adresse = adresse;
		this.Prix_range = prix_range;
		this.ville = ville;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPrix_range() {
		return Prix_range;
	}

	public void setPrix_range(String prix_range) {
		Prix_range = prix_range;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
