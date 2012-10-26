package com.objet.aliment;

import java.awt.Color;
import java.awt.Graphics;

import com.main.Saison1;
import com.objet.ObjetLoft;

public class Aliment extends ObjetLoft {

	public Aliment(String name) {
		this.setNom(name);
		color = Color.black;
	}
	
	@Override
	public void manger(ObjetLoft o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDeplacer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche() {
		System.out.println(this.getNom() + "() [" + this.getPosition_x() + ", " + this.getPosition_y() + "]");		
	}

	@Override
	public void dessinerObjet(Graphics g) {
		g.setColor(color);
		g.fillRect(position_x*Saison1.tailleFenetre/Saison1.tailleLoft, position_y*Saison1.tailleFenetre/Saison1.tailleLoft, Saison1.tailleFenetre/(2*Saison1.tailleLoft), Saison1.tailleFenetre/(2*Saison1.tailleLoft));		
	}
	
}
