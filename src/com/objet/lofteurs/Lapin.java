package com.objet.lofteurs;

import java.awt.Color;

import com.loft.Loft;


public class Lapin extends Neuneu {

	public Lapin(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		color = Color.magenta;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void seDeplacer() {
		//On prend l'alliment le plus proche
		this.seDeplacer(this.getLoft().getProcheNeuneu(this));	
	}
}
