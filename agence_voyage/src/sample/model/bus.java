package sample.model;


public class bus {
	private int id_bus;
	private String image_bus;
	private String nom_bus;
	private String immatriculation;
	private int id_ch;
	private int num_cb;
	
	public bus() {
	}
	
	public bus(int id_bus, String image_bus,String nom_bus, String immatriculation, int id_ch, int num_cb) {

		this.id_bus = id_bus;
		this.image_bus=image_bus;
		this.nom_bus = nom_bus;
		this.immatriculation = immatriculation;
		this.id_ch = id_ch;
		this.num_cb = num_cb;
	}
	
	public int getId_bus() {
		return id_bus;
	}
	public void setId_bus(int id_bus) {
		this.id_bus = id_bus;
	}
	
	public String getNom_bus() {
		return nom_bus;
	}
	public void setNom_bus(String nom_bus) {
		this.nom_bus = nom_bus;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public int getId_ch() {
		return id_ch;
	}
	public void setId_ch(int id_ch) {
		this.id_ch = id_ch;
	}
	public int getNum_cb() {
		return num_cb;
	}
	public void setNum_cb(int num_cb) {
		this.num_cb = num_cb;
	}

	public String getImage_bus() {
		return image_bus;
	}

	public void setImage_bus(String image_bus) {
		this.image_bus = image_bus;
	}
	
	
	
}
