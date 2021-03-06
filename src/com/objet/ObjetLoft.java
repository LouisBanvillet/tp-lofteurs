package com.objet;

import java.awt.Color;

import com.graphique.ObjetDessinable;

public abstract class ObjetLoft implements ObjetDessinable{
	protected int position_x;
	protected int position_y;
	
	protected String nom;
	
	protected int energie;
	protected int case_deplacement;
	protected Color color;
	
	public double getDistance(ObjetLoft o){
		double distance = Math.sqrt(
				(this.getPosition_x() - o.getPosition_x()) * (this.getPosition_x() - o.getPosition_x()) +
				(this.getPosition_y() - o.getPosition_y()) * (this.getPosition_y() - o.getPosition_y()));
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
	
	public abstract void manger();
	public abstract void seDeplacer();
	public abstract void affiche();
}
