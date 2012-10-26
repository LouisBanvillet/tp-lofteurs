package com.objet.lofteurs;
import java.awt.Color;

import com.loft.Loft;


public class Cannibale extends Vorace {

	public Cannibale(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		color = Color.orange;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void seDeplacer() {
		//On prend l'objet le plus proche
		this.seDeplacer(this.getLoft().getProcheObjet(this));
	}
}
