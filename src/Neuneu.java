
public class Neuneu extends ObjetLoft {
	protected Loft loft;
	
	public Loft getLoft() {
		return loft;
	}

	public void setLoft(Loft loft) {
		this.loft = loft;
	}

	public Neuneu(String nom, int energie, int caseDeplacement, Loft loft) {
		this.setNom(nom);
		this.setEnergie(energie);
		this.setCase_deplacement(caseDeplacement);
		this.setLoft(loft);
	}
	
	public void seReproduire(Neuneu neuneu) {
		
	}

	@Override
	public void manger(ObjetLoft o) {
		int e = this.getEnergie() + o.getEnergie();
		this.setEnergie(Math.min(e, 100));
		o.setEnergie(Math.max(0, e - this.getEnergie()));
	}

	@Override
	public void seDeplacer() {
		int choix = (int)(Math.random() * 4);
		switch(choix) {
			case 0:
				this.setPosition_x(Math.max(0, this.getPosition_y() - this.getCase_deplacement()));
				break;
			case 1:
				this.setPosition_y(Math.min(loft.w - 1, this.getPosition_y() + this.getCase_deplacement()));
				break;
			case 2:
				this.setPosition_y(Math.min(loft.h - 1, this.getPosition_y() + this.getCase_deplacement()));
				break;
			case 3: 
				this.setPosition_x(Math.max(0, this.getPosition_x() - this.getCase_deplacement()));
				break;
		}
		this.setEnergie(this.getEnergie() - 10);
	}

	@Override
	public void affiche() {
		System.out.println(this.getNom() + "() [" + this.getPosition_x() + ", " + this.getPosition_y() + "]");
	}
	
	public void action() {
		
	}
}
