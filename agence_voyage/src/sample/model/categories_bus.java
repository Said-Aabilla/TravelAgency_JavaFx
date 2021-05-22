package sample.model;

public class categories_bus {
private int num_cb;
private String libelle_cb;
private int capacite_cb;

public categories_bus() {
}

public categories_bus(int num_cb, String libelle_cb, int capacite_cb) {
	this.num_cb = num_cb;
	this.libelle_cb = libelle_cb;
	this.capacite_cb = capacite_cb;
}

public int getNum_cb() {
	return num_cb;
}

public void setNum_cb(int num_cb) {
	this.num_cb = num_cb;
}

public String getLibelle_cb() {
	return libelle_cb;
}

public void setLibelle_cb(String libelle_cb) {
	this.libelle_cb = libelle_cb;
}

public int getCapacite_cb() {
	return capacite_cb;
}

public void setCapacite_cb(int capacite_cb) {
	this.capacite_cb = capacite_cb;
}



}
