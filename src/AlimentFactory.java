
public class AlimentFactory {
	public static InfoObjetLoft[] infos;
	
	public static void init() {
		infos = new InfoObjetLoft[4];

		infos[0] = new InfoObjetLoft(Nourriture.class.getName(), 50, 0);
		infos[1] = new InfoObjetLoft(Boisson.class.getName(), 30, 0);
		infos[2] = new InfoObjetLoft(Alcool.class.getName(), -5, 1);
	}
	
	public static Aliment createAliment(String name){
		int choix = (int)Math.random() * infos.length;
		
		return infos[choix].getInstanceAliment(name);
	}
}
