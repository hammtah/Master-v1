package master.beans;

public class Facultes {
	private int id_facultes;
	private String nom;
	private String surnom;
	private String logo;
	//private Universite uni;
	
	public int getId_facultes() {
		return id_facultes;
	}
	public void setId_facultes(int id_facultes) {
		this.id_facultes = id_facultes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
