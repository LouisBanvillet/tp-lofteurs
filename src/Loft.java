import java.util.ArrayList;


public class Loft {
	
	protected int w, h;
	protected ObjetLoft loftTable[][] = new ObjetLoft[w][h];
	protected ArrayList<Neuneu> population = new ArrayList<Neuneu>();
	
	public Loft(){
		this(10, 10);
	}
	
	public Loft(int width, int height){
		w=width;
		h=height;
		int numeroNeuneu=1;
		for(int i=0; i<w; i++) {
	        for(int j=0; j<h; j++) {
	        	//random<3 : case vide; 3<=random<5 : aliment; 5<=random<6 : lofteur
	        	int random = (int)(Math.random() * (6));
	        	if(random>=3 && random<5){
	        		loftTable[i][j] = AlimentFactory.createAliment();
	        	}
	        	if(random>=5 && random<6){
	        		loftTable[i][j] = NeuneuFactory.createNeuneu("Neuneu" + numeroNeuneu);
	        		population.add((Neuneu) loftTable[i][j]);
	        		numeroNeuneu++;
	        	}
	        }
		}
	}
	
	public Neuneu getProcheNeuneu(Neuneu n){
		Neuneu procheNeuneu = null;
		
		for(int i=0; i<population.size(); i++){
			//si la distance est nulle, on ne considère pas ce Neuneu
			if(n.getDistance(population.get(i))!=0){
				if(procheNeuneu==null){procheNeuneu=population.get(i);}
				else if(n.getDistance(population.get(i))<n.getDistance(procheNeuneu)){
					procheNeuneu=population.get(i);
				}
			}
		}
		
		return null;
	}
	
	
	//getters et setters

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public ObjetLoft[][] getLoftTable() {
		return loftTable;
	}

	public void setLoftTable(ObjetLoft[][] loftTable) {
		this.loftTable = loftTable;
	}

	public ArrayList<Neuneu> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<Neuneu> population) {
		this.population = population;
	}
	
}
