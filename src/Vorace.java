
public class Vorace extends Erratique {

	public Vorace(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void seDeplacer() {
		//On prend l'alliment le plus proche
		System.out.println("bla");
		this.seDeplacer(this.getLoft().getProcheAliment(this));
	}
}
