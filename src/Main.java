
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NeuneuFactory.init();
		AlimentFactory.init();
		
		Loft l = new Loft();
		l.affichePlateau();
		l.go();
	}

}
