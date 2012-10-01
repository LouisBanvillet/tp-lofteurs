
public class InfoObjetLoft {
	private String classNom;
	private int energie;
	private int caseDeplacement;
	
	public String getClassNom() {
		return classNom;
	}
	public void setClassNom(String className) {
		this.classNom = className;
	}
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	public int getCaseDeplacement() {
		return caseDeplacement;
	}
	public void setCaseDeplacement(int caseDeplacement) {
		this.caseDeplacement = caseDeplacement;
	}
	
	public InfoObjetLoft(String nom, int energie, int caseDeplacement) {
		this.setClassNom(nom);
		this.setEnergie(energie);
		this.setCaseDeplacement(caseDeplacement);
	}
	
	/**
	 * Retourne l'instance d'un neuneu.
	 * Retourne un Erratique de base
	 * @return
	 */
	public Neuneu getInstanceNeuneu(String name) {
		if(this.getClassNom().equals(Lapin.class.getName())) {
			return new Lapin(name);
		} else if(this.getClassNom().equals(Cannibale.class.getName())) {
			return new Cannibale(name);
		} else if(this.getClassNom().equals(Vorace.class.getName())) {
			return new Vorace(name);
		} else if(this.getClassNom().equals(Erratique.class.getName())) {
			return new Erratique(name);
		} else {
			return new Neuneu(name);
		}
	}
	
	public Aliment getInstanceAliment(String name) {
		if(this.getClassNom().equals(Boisson.class.getName())) {
			return new Boisson(name);
		} else if(this.getClassNom().equals(Alcool.class.getName())) {
			return new Alcool(name);
		} else if(this.getClassNom().equals(Nourriture.class.getName())) {
			return new Nourriture(name);
		} else {
			return new Aliment(name);
		}
	}
}
