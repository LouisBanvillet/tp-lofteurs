package com.main;


import com.graphique.ZoneGraphique;
import com.loft.Loft;
import com.objet.aliment.AlimentFactory;
import com.objet.lofteurs.Cannibale;
import com.objet.lofteurs.Erratique;
import com.objet.lofteurs.NeuneuFactory;
import com.objet.lofteurs.Vorace;

public class Saison1 {

	public static int nombreLofteurs = 4;
	public static int tailleFenetre = 600;
	public static int tailleLoft = 30;
	public static float proportionErratique = .75f;
	public static float proportionVorace = .25f;
	public static float proportionCannibale = 0f;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		NeuneuFactory.init();
		AlimentFactory.init();
		
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(tailleLoft,zone);
		
		zone.ajouterObjet(loft);
		
		loft.go();
	}

}
