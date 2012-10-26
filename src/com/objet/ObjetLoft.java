package com.objet;

public abstract class ObjetLoft {
	protected int position_x;
	protected int position_y;
	
	protected String nom;
	
	protected int energie;
	protected int case_deplacement;
	
	public int getDistance(ObjetLoft o){
		int distance = Math.abs(this.position_x-o.position_x) + Math.abs(this.position_y - o.position_y);
		return distance;
	}

	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	public int getCase_deplacement() {
		return case_deplacement;
	}
	public void setCase_deplacement(int case_deplacement) {
		this.case_deplacement = case_deplacement;
	}
	
	public abstract void manger(ObjetLoft o);
	public abstract void seDeplacer();
	public abstract void affiche();
}
