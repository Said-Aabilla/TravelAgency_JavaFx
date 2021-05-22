package sample.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voyage {

	private int id_voyage;
	private String libelle_voyage;
	private LocalDate date_deb;
	private LocalDate date_fin;
	private LocalTime heure_debut;
	private LocalTime heure_fin;
	private int cp_ville;
	private int id_bus;
	private int id_res;
	
	
	public int getId_voyage() {
		return id_voyage;
	}
	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}
	public String getLibelle_voyage() {
		return libelle_voyage;
	}
	public void setLibelle_voyage(String libelle_voyage) {
		this.libelle_voyage = libelle_voyage;
	}
	public LocalDate getDate_deb() {
		return date_deb;
	}
	public void setDate_deb(LocalDate date_deb) {
		this.date_deb = date_deb;
	}
	public LocalDate getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}
	public LocalTime getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(LocalTime heure_debut) {
		this.heure_debut = heure_debut;
	}
	public LocalTime getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(LocalTime heure_fin) {
		this.heure_fin = heure_fin;
	}
	public int getCp_ville() {
		return cp_ville;
	}
	public void setCp_ville(int cp_ville) {
		this.cp_ville = cp_ville;
	}
	public int getId_bus() {
		return id_bus;
	}
	public void setId_bus(int id_bus) {
		this.id_bus = id_bus;
	}
	public int getId_res() {
		return id_res;
	}
	public void setId_res(int id_res) {
		this.id_res = id_res;
	}
	
	

	
}
