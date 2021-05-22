package sample.model;

public class choisir {

	private int id_hotel;
	private int id_client;
	public choisir() {
	}
	
	public choisir(int id_hotel, int id_client) {
		this.id_hotel = id_hotel;
		this.id_client = id_client;
	}
	
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	
}
