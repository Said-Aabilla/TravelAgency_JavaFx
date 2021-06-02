package sample.util;

public class voyage_info {
    private String id_voyage;
    private String libelle_voyage;
    private String date_deb;
    private String date_fin;
    private String heure_debut;
    private String heure_fin;
    private String id_bus;
    private String ville_depart;
    private String ville_arrive;

    public voyage_info(String date_deb, String id_bus, String ville_depart, String ville_arrive) {
		super();
		this.date_deb = date_deb;
		this.id_bus = id_bus;
		this.ville_depart = ville_depart;
		this.ville_arrive = ville_arrive;
	}

	public voyage_info(String id_voyage, String libelle_voyage, String date_deb, String date_fin, String heure_debut, String heure_fin, String id_bus, String ville_depart, String ville_arrive) {
        this.id_voyage = id_voyage;
        this.libelle_voyage = libelle_voyage;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.id_bus = id_bus;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
    }

    public String getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(String id_voyage) {
        this.id_voyage = id_voyage;
    }

    public String getLibelle_voyage() {
        return libelle_voyage;
    }

    public void setLibelle_voyage(String libelle_voyage) {
        this.libelle_voyage = libelle_voyage;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getId_bus() {
        return id_bus;
    }

    public void setId_bus(String id_bus) {
        this.id_bus = id_bus;
    }



    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrive() {
        return ville_arrive;
    }

    public void setVille_arrive(String ville_arrive) {
        this.ville_arrive = ville_arrive;
    }





}
