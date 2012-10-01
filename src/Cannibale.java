
public class Cannibale extends Vorace {

	public Cannibale(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void seDeplacer() {
		//On prend l'objet le plus proche
		this.seDeplacer(this.getLoft().getProcheObjet(this));
	}
}
