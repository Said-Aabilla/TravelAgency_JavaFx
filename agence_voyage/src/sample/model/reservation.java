package sample.model;
import java.time.LocalDate;
import java.util.*;
public class reservation {

	private int No_res;
	private int nbr_places;
	private LocalDate date_res;
	private int num_billet;
	private int id_client;
	public reservation() {
	}
	public reservation(int no_res, int nbr_places, LocalDate date_res, int num_billet, int id_client) {
		
		No_res = no_res;
		this.nbr_places = nbr_places;
		this.date_res = date_res;
		this.num_billet = num_billet;
		this.id_client = id_client;
	}
	public int getNo_res() {
		return No_res;
	}
	public void setNo_res(int no_res) {
		No_res = no_res;
	}
	public int getNbr_places() {
		return nbr_places;
	}
	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}
	public Date getDate_res() {
		return date_res;
	}
	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}
	public int getNum_billet() {
		return num_billet;
	}
	public void setNum_billet(int num_billet) {
		this.num_billet = num_billet;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	


	
}
