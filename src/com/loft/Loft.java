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
	protected ObjetLoft loftTable[][];
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
		loftTable = new ObjetLoft[w][h];
		int numeroNeuneu=1;
		int numeroAliment=1;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				//random<3 : case vide; 3<=random<5 : aliment; 5<=random<6 : lofteur
				int random = (int)(Math.random() * (6));
				if(random>=3 && random<5){
					loftTable[i][j] = AlimentFactory.createAliment("Aliment" + numeroAliment);
					listeAliment.add((Aliment) loftTable[i][j]);
					loftTable[i][j].setPosition_x(i);
					loftTable[i][j].setPosition_y(j);
					//System.out.println("bla");
					numeroAliment++;
				}
				if(random>=5 && random<6){
					loftTable[i][j] = NeuneuFactory.createNeuneu("Neuneu" + numeroNeuneu, this);
					population.add((Neuneu) loftTable[i][j]);
					loftTable[i][j].setPosition_x(i);
					loftTable[i][j].setPosition_y(j);
					numeroNeuneu++;
				}
			}
		}
		
		for(Aliment n : listeAliment){
			n.affiche();
			System.out.println("bla");
		}
	}


	//méthode régissant la partie
	public void go(){
		int tour=1;
		while(population.size()>0 && tour<1){
			System.out.println("tour " + tour);
			for(Neuneu n : population){
				n.seDeplacer();
				n.affiche();
			}
			for(Aliment n : listeAliment){
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
					listeAliment.remove(incrementAliment);
				}
			}

			majTableau();
			affichePlateau();
			tour++;
			try{
				Thread.sleep(1000);				
			}catch (InterruptedException e) {  
				e.printStackTrace();  
			}  

			zone.repaint();
		}
	}

	public void affichePlateau(){
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(loftTable[i][j]==null){System.out.print("-");}
				if(loftTable[i][j] instanceof Lapin){System.out.print("l");}
				if(loftTable[i][j] instanceof Cannibale){System.out.print("c");}
				if(loftTable[i][j] instanceof Vorace && !(loftTable[i][j] instanceof Cannibale)){System.out.print("v");}
				if(loftTable[i][j] instanceof Erratique && !(loftTable[i][j] instanceof Vorace)){System.out.print("e");}
				if(loftTable[i][j] instanceof Aliment){System.out.print("a");}
			}
			System.out.print("\n");
		}
	}

	public void majTableau(){
		loftTable = new ObjetLoft[w][h];
		for(Neuneu n:population) {
			loftTable[n.getPosition_x()][n.getPosition_y()]=n;
		}

		for(Aliment a:listeAliment) {
			loftTable[a.getPosition_x()][a.getPosition_y()]=a;
		}
	}


	//renvoie le neuneu le plus proche de l'objet en paramètre
	public Neuneu getProcheNeuneu(ObjetLoft o){
		Neuneu procheNeuneu = null;

		for(int i=0; i<population.size(); i++){
			//si la distance est nulle, on ne considère pas ce Neuneu
			if(o.getDistance(population.get(i))!=0){
				if(procheNeuneu==null){procheNeuneu=population.get(i);}
				else if(o.getDistance(population.get(i))<o.getDistance(procheNeuneu)){
					procheNeuneu=population.get(i);
				}
			}
		}

		return procheNeuneu;
	}

	//renvoie l'objet le plus proche de l'objet en paramètre
	public Aliment getProcheAliment(ObjetLoft o){
		Aliment procheObjet = null;

		//puis la population d'objet		
		for(int i=0; i<listeAliment.size(); i++){
			//si la distance est nulle, on ne considère pas cet objet
			if(o.getDistance(listeAliment.get(i))!=0){
				if(procheObjet==null){procheObjet=listeAliment.get(i);}
				else if(o.getDistance(listeAliment.get(i))<o.getDistance(procheObjet)){
					procheObjet=listeAliment.get(i);
				}
			}
		}

		return procheObjet;
	}

	//renvoie l'objet le plus proche de l'objet en paramètre
	public ObjetLoft getProcheObjet(ObjetLoft o){
		ObjetLoft procheObjet = null;

		if(getProcheNeuneu(o)!=null){
			procheObjet=getProcheNeuneu(o);
		}

		if(getProcheAliment(o)!=null){
			if(getProcheNeuneu(o)!=null){
				if(o.getDistance(getProcheAliment(o))<o.getDistance(getProcheNeuneu(o))){
					procheObjet=getProcheAliment(o);						
				}
			}
			else{procheObjet=getProcheAliment(o);}
		}			

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

	public ObjetLoft[][] getLoftTable() {
		return loftTable;
	}

	public void setLoftTable(ObjetLoft[][] loftTable) {
		this.loftTable = loftTable;
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
		for (ObjetDessinable x : listeAliment) {
			x.dessinerObjet(g);
		}

		for (ObjetDessinable x : population) {
			x.dessinerObjet(g);
		}
	}

}
