package algorithm;

public class Antibody {
	/*
	 * 
	 */
	private int[][] antibodies;
	//La pone como 13 para tener una referencia inicial, ya que el valor con el paso del tiempo cambia
	//mientras menor sea es mejor la afinidad
	private int affinity = 13;
	//antigeno objetivo
	private Antigen targetAntigen;
	//anticuerpo parentesco, un anticuerpo clonado
	private Antibody parentAntibody;

	public Antibody(int x, int y) {
		antibodies = generateAb(x, y);
		targetAntigen = new Antigen();
		parentAntibody = null;
	}

	//Genera un anticuerpo con datos randomicos, y los redondea para ser 0 o 1
	public int[][] generateAb(int x, int y) {
		int[][] arr = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++)
				arr[i][j] = (int) Math.round(Math.random());
		}
		return arr;
	}

	//Determina la afinidad del anticuerpo
	public void countAffinity(Antigen ag) {
		int affinity = 0;
		for (int i = 0; i < antibodies.length; i++)
			for (int j = 0; j < antibodies[0].length; j++)
				//Por cada elemnoto que no coincida incrementa la afinidad
				if (antibodies[i][j] != ag.getAntigens()[i][j]) {
					affinity++;
				}
		//si la afinidad del anticuerpo es menos apropiada de la afinidad creada
		//Setea la afinidad mas apropiada
		//Setea el antigeno abjetivo mas apriado
		if (affinity < this.affinity) {
			this.affinity = affinity;
			this.targetAntigen = ag;
		}
	}

	//mutacion
	public int[][] mutate() {
		int[][] arr = new int[antibodies.length][antibodies[0].length];
		for (int i = 0; i < antibodies.length; i++) {
			for (int j = 0; j < antibodies[0].length; j++) {
				//Genera un numero aleatorio y si es menor a 30
				if (this.getRandom() < 30) {
					//lo muta
					arr[i][j] = antibodies[i][j] ^ 1;
				} else {
					//Solo lo almacena
					arr[i][j] = antibodies[i][j];
				}
			}
		}
		return arr;
	}

	//genera un nuemor del 1 al 100
	public int getRandom() {
		return (int) (Math.random() * 100);
	}

	public Antigen getTargetAntigen() {
		return targetAntigen;
	}

	/*
	 * getters y setters
	 */
	public Antibody getParentAntibody() {
		return parentAntibody;
	}

	public void setTargetAntigen(Antigen targetAntigen) {
		this.targetAntigen = targetAntigen;
	}

	public void setParentAntibody(Antibody parentAntibody) {
		this.parentAntibody = parentAntibody;
	}

	public int[][] getAntibodies() {
		return antibodies;
	}

	public void setAntibodies(int[][] antibodies) {
		this.antibodies = antibodies;
	}

	public int getAffinity() {
		return affinity;
	}

	public void setAffinity(int affinity) {
		this.affinity = affinity;
	}

	/*
	 * 
	 */
	@Override
	public String toString() {
		String l = "";
		for (int i = 0; i < antibodies.length; i++) {
			for (int j = 0; j < antibodies[0].length; j++) {
				l += antibodies[i][j] + "  ";
			}
			l += "\n";
		}
		l += "Affinity:" + affinity + "\n";
		return l;
	}
}
