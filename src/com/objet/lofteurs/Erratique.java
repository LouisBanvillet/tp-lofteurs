package com.objet.lofteurs;
import java.awt.Color;
import com.loft.Loft;

public class Erratique extends Neuneu {

	public Erratique(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		color = Color.green;
	}
	
	@Override
	public void manger() {
		this.manger(this.getLoft().getAlimentCase(this.getPosition_x(), this.getPosition_y()));
	}
}
