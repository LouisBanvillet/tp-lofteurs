package com.objet.lofteurs;
import java.awt.Color;

import com.loft.Loft;


public class Vorace extends Erratique {

	public Vorace(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		color = Color.cyan;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void seDeplacer() {
		//On prend l'alliment le plus proche
		this.seDeplacer(this.getLoft().getProcheAliment(this));
	}
	
	@Override
	public void manger() {
		this.manger(this.getLoft().getAlimentCase(this.getPosition_x(), this.getPosition_y()));
	}
}
