package com.loft;
import java.awt.Graphics;
import java.util.ArrayList;

import com.graphique.ObjetDessinable;
import com.graphique.ZoneGraphique;
import com.objet.ObjetLoft;
import com.objet.aliment.Aliment;
import com.objet.aliment.AlimentFactory;
import com.objet.lofteurs.Cannibale;
import com.objet.lofteurs.Erratique;
import com.objet.lofteurs.Lapin;
import com.objet.lofteurs.Neuneu;
import com.objet.lofteurs.NeuneuFactory;
import com.objet.lofteurs.Vorace;


public class Loft implements ObjetDessinable{

	protected int w, h;
	protected ArrayList<Neuneu> population = new ArrayList<Neuneu>();
	protected ArrayList<Aliment> listeAliment = new ArrayList<Aliment>();
	protected ZoneGraphique zone;

	public Loft(int taille, ZoneGraphique z){
		this(taille, taille, z);
	}

	public Loft(int width, int height, ZoneGraphique z){
		zone = z;
		w=width;
		h=height;
		int numeroNeuneu=1;
		int numeroAliment=1;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				//random<3 : case vide; 3<=random<5 : aliment; 5<=random<6 : lofteur
				int random = (int)(Math.random() * (6));
				if(random>=3 && random<5){
					Aliment a = AlimentFactory.createAliment("Aliment" + numeroAliment);
					listeAliment.add(a);
					a.setPosition_x(i);
					a.setPosition_y(j);
					numeroAliment++;
				}
				if(random>=5 && random<6 && population.size() < 3){
					Neuneu n = NeuneuFactory.createNeuneu("Neuneu" + numeroNeuneu, this);
					population.add(n);
					n.setPosition_x(i);
					n.setPosition_y(j);
					numeroNeuneu++;
				}
			}
		}
	}


	//méthode régissant la partie
	public void go(){
		int tour=1;
		while(population.size()>0 && tour<100){
			System.out.println("tour " + tour);
			for(Aliment n : listeAliment){
				//n.affiche();
			}
			for(Neuneu n : population){
				n.seDeplacer();
				n.setEnergie(n.getEnergie() - 5);
				n.manger();
				n.affiche();
			}
			
			int incrementNeuneu=0;
			while(incrementNeuneu<population.size()){
				population.get(incrementNeuneu).action();
				if(population.get(incrementNeuneu).getEnergie()<=0){
					population.remove(incrementNeuneu);
				}
				else{incrementNeuneu++;}
			}
			int incrementAliment=0;
			while(incrementAliment<listeAliment.size()){
				if(listeAliment.get(incrementAliment).getEnergie()<=0){
					listeAliment.get(incrementAliment).affiche();
					listeAliment.remove(incrementAliment);
				}
				else {incrementAliment++;}
			}

			tour++;
			try{
				Thread.sleep(500);				
			}catch (InterruptedException e) {  
				e.printStackTrace();  
			}  

			zone.repaint();
		}
	}

	//renvoie le neuneu le plus proche de l'objet en paramètre
	public Neuneu getProcheNeuneu(ObjetLoft o){
		Neuneu procheNeuneu = null;

		for(Neuneu n : population){
			//si la distance est nulle, on ne considère pas ce Neuneu
			//if(o.getDistance(population.get(i))!=0){
			if(o.getNom() != n.getNom()) {
				if(procheNeuneu==null) {
					procheNeuneu=n;
				} else if(o.getDistance(n)<o.getDistance(procheNeuneu)) {
					procheNeuneu=n;
				}
			}
		}

		return procheNeuneu;
	}

	public Neuneu getNeuneuCase(String name, int x, int y) {
		//puis la population d'objet		
		for(Neuneu n : population){
			if(n.getPosition_x() == x && n.getPosition_y() == y && n.getNom() != name)
				return n;
		}

		return null;
	}
	
	public Aliment getAlimentCase(int x, int y) {
		//puis la population d'objet		
		for(Aliment a : listeAliment){
			if(a.getPosition_x() == x && a.getPosition_y() == y)
				return a;
		}

		return null;
	}
	
	//renvoie l'objet le plus proche de l'objet en paramètre
	public Aliment getProcheAliment(ObjetLoft o){
		Aliment procheObjet = null;

		//puis la population d'objet		
		for(Aliment a : listeAliment){
			//si la distance est nulle, on ne considère pas cet objet
			//if(o.getDistance(listeAliment.get(i))!=0){
				if(procheObjet == null) {
					procheObjet=a;
				} else if(o.getDistance(a) < o.getDistance(procheObjet)) {
					procheObjet=a;
				}
			//}
		}

		return procheObjet;
	}

	//renvoie l'objet le plus proche de l'objet en paramètre
	public ObjetLoft getProcheObjet(ObjetLoft o){
		ObjetLoft procheObjet = null;
		
		if(getProcheNeuneu(o) != null){
			procheObjet=getProcheNeuneu(o);
		}

		if(getProcheAliment(o) != null){
			if(getProcheNeuneu(o) != null){
				if(o.getDistance(getProcheAliment(o)) < o.getDistance(getProcheNeuneu(o))){
					procheObjet=getProcheAliment(o);						
				}
			}
			else {
				procheObjet=getProcheAliment(o);
			}
		}			

		System.out.println(procheObjet == null ? "null" : procheObjet.getNom());
		return procheObjet;
	}


	//getters et setters

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public ArrayList<Neuneu> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<Neuneu> population) {
		this.population = population;
	}

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < listeAliment.size() ; i++) {
			listeAliment.get(i).dessinerObjet(g);
		}

		for (int i = 0 ; i < population.size() ; i++) {
			population.get(i).dessinerObjet(g);
		}
	}

}
