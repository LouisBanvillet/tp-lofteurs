
public abstract class Neuneu extends ObjetLoft {
	protected Loft loft;
	
	public Loft getLoft() {
		return loft;
	}

	public void setLoft(Loft loft) {
		this.loft = loft;
	}

	public abstract void seReproduire(Neuneu neuneu);
}
