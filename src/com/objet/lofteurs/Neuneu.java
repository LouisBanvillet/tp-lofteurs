package com.objet.lofteurs;
import java.awt.Graphics;

import com.loft.Loft;
import com.main.Saison1;
import com.objet.ObjetLoft;



public class Neuneu extends ObjetLoft {
	protected Loft loft;
	
	public Loft getLoft() {
		return loft;
	}

	public void setLoft(Loft loft) {
		this.loft = loft;
	}

	public Neuneu(String nom, int energie, int caseDeplacement, Loft loft) {
		this.setNom(nom);
		this.setEnergie(energie);
		this.setCase_deplacement(caseDeplacement);
		this.setLoft(loft);
	}
	
	public void seReproduire(Neuneu neuneu) {
		
	}

	@Override
	public void manger() {
		this.manger(null);
	}
	
	public void manger(ObjetLoft o) {
		if(o != null) {
			int e = this.getEnergie() + o.getEnergie();
			this.setEnergie(Math.min(e, 100));
			o.setEnergie(Math.max(0, e - this.getEnergie()));
		}
	}

	@Override
	public void seDeplacer() {
		this.seDeplacer(null);
	}
	
	//On se déplace suivant un objet du loft
	public void seDeplacer(ObjetLoft a) {
		if(a == null) {
			int choix = (int)(Math.random() * 4);
			switch(choix) {
				case 0:
					this.seDeplacerHaut();
					break;
				case 1:
					this.seDeplacerDroite();
					break;
				case 2:
					this.seDeplacerBas();
					break;
				case 3: 
					this.seDeplacerGauche();
					break;
			}
		} else {
			if(Math.abs(this.getPosition_x() - a.getPosition_x()) < Math.abs(this.getPosition_y() - a.getPosition_y())) {
				if(this.getPosition_x() > a.getPosition_x()) {
					this.seDeplacerGauche();
				} else {
					this.seDeplacerDroite();
				}
			} else {
				if(this.getPosition_y() > a.getPosition_y()) {
					this.seDeplacerHaut();
				} else {
					this.seDeplacerBas();
				}
			}
		}
		
		this.setEnergie(this.getEnergie() - 10);
	}	
	public void seDeplacerHaut() {
		this.setPosition_y(Math.max(0, this.getPosition_y() - this.getCase_deplacement()));
	}
	
	public void seDeplacerDroite() {
		this.setPosition_x(Math.min(loft.getW() - 1, this.getPosition_x() + this.getCase_deplacement()));
	}
	
	public void seDeplacerBas() {
		this.setPosition_y(Math.min(loft.getH() - 1, this.getPosition_y() + this.getCase_deplacement()));
	}
	
	public void seDeplacerGauche() {
		this.setPosition_x(Math.max(0, this.getPosition_x() - this.getCase_deplacement()));
	}

	@Override
	public void affiche() {
		System.out.println(this.getNom() + "() [" + this.getPosition_x() + ", " + this.getPosition_y() + "]");
	}
	
	
	public void action() {
		
	}

	@Override
	public void dessinerObjet(Graphics g) {
		g.setColor(color);
		g.fillOval(position_x*Saison1.tailleFenetre/Saison1.tailleLoft, position_y*Saison1.tailleFenetre/Saison1.tailleLoft, Saison1.tailleFenetre/(2*Saison1.tailleLoft), Saison1.tailleFenetre/(2*Saison1.tailleLoft));		
	}
	
}
