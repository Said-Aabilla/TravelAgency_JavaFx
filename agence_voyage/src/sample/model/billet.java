package sample.model;

import java.time.LocalDate;
import java.util.Date;
public class billet {

private int num_billet;
private String num_ordre;
private double montant;
private LocalDate date_vente;
private String mode_paiement;
private String etat_billet;

public billet() {
	}

public billet(int num_billet, String num_ordre, double montant, LocalDate date_vente, String mode_paiement,
		String etat_billet) {
	this.num_billet = num_billet;
	this.num_ordre = num_ordre;
	this.montant = montant;
	this.date_vente = date_vente;
	this.mode_paiement = mode_paiement;
	this.etat_billet = etat_billet;
}

public int getNum_billet() {
	return num_billet;
}
public void setNum_billet(int num_billet) {
	this.num_billet = num_billet;
}
public String getNum_ordre() {
	return num_ordre;
}
public void setNum_ordre(String num_ordre) {
	this.num_ordre = num_ordre;
}
public double getMontant() {
	return montant;
}

public void setMontant(double montant) {
	this.montant = montant;
}
public Date getDate_vente() {
	return date_vente;
}
public void setDate_vente(Date date_vente) {
	this.date_vente = date_vente;
}
public String getMode_paiement() {
	return mode_paiement;
}
public void setMode_paiement(String mode_paiement) {
	this.mode_paiement = mode_paiement;
}
public String getEtat_billet() {
	return etat_billet;
}
public void setEtat_billet(String etat_billet) {
	this.etat_billet = etat_billet;
}
}

