package com.objet.lofteurs;
import com.loft.Loft;
import com.objet.InfoObjetLoft;



public class NeuneuFactory {
	public static InfoObjetLoft[] infos;
	
	public static void init() {
		infos = new InfoObjetLoft[4];

		infos[0] = new InfoObjetLoft(Lapin.class.getName(), 100, 1);
		infos[1] = new InfoObjetLoft(Erratique.class.getName(), 100, 1);
		infos[2] = new InfoObjetLoft(Vorace.class.getName(), 100, 1);
		infos[3] = new InfoObjetLoft(Cannibale.class.getName(), 100, 1);
	}
	
	public static Neuneu createNeuneu(String name, Loft loft) {
		int choix = 1; //(int)(Math.random() * infos.length);
		
		return infos[choix].getInstanceNeuneu(name, loft);
	}
}
