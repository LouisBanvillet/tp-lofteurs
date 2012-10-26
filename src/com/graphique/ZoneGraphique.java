package com.graphique;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.main.Saison1;

/**
 * une classe comportant une zone graphique dans laquelle on peut dessiner ;
 * le dessin est refait automatiquement par la classe Panel associée ; tous
 * les objets de type ObjetDessinable ajoutés à la liste sont redessinés par 
 * un appel à leur méthode dessinerObjet(Graphics g)
 * 
 * @see ObjectDessinable,LoftPanel
 * @author moreau
 *
 */
public class ZoneGraphique extends JFrame {

	/**
	 * la liste d'objets à dessiner
	 */
	LinkedList<ObjetDessinable> liste;
	
	/**
	 * constructeur
	 *
	 * @param titre le nom de l'application
	 */
	public ZoneGraphique(String titre)  {
		// appel au constructeur de base
		super(titre);
		
		// ajout d'une taille par défaut
		setSize(Saison1.tailleFenetre, Saison1.tailleFenetre);
		
		// création de la liste d'objets
		liste = new LinkedList<ObjetDessinable>();
		
		// ajout d'un listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0) ;
			}
	    	} ) ;

		// création du panneau
		LoftPanel a = new LoftPanel(liste);
		getContentPane().add(a);
		
		setVisible(true);
	}
	
	/**
	 * ajout d'un objet dans la zone graphique
	 */
	public void ajouterObjet(ObjetDessinable o) {
		liste.add(o);
	}
	
	/**
	 * largeur de la partie dessinable
	 */
	public int getWidth() {
		return getContentPane().getWidth();
	}
	
	/**
	 * hauteur de la partie dessinable
	 */
	public int getHeight() {
		return getContentPane().getHeight();
	}
	
}
