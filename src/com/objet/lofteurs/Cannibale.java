package com.objet.lofteurs;
import java.awt.Color;

import com.loft.Loft;
import com.objet.aliment.Aliment;


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
	
	@Override
	public void manger() {
		Aliment a = this.getLoft().getAlimentCase(this.getPosition_x(), this.getPosition_y());
		if(a == null)
			this.manger(this.getLoft().getNeuneuCase(this.getNom(), this.getPosition_x(), this.getPosition_y()));
		else
			this.manger(a);
	}
}
