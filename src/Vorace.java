
public class Vorace extends Erratique {

	public Vorace(String nom, int energie, int caseDeplacement, Loft loft) {
		super(nom, energie, caseDeplacement, loft);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void seDeplacer() {
		Aliment a = this.getLoft().getProcheAliment(this);
		this.setEnergie(this.getEnergie() - 10);
	}
}
