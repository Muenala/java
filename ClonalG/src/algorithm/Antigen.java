package algorithm;

//Al ser una matriz, se puede representar una forma, como apra el reconocimiento de patrones o de imagenes
public class Antigen {
	private int[][] antigens;

	/*
	 * Constructores
	 */
	public Antigen(int[][] antigenos) {
		this.antigens = antigenos;
	}

	public Antigen() {
		this.antigens = null;
	}

	/*
	 * Getter
	 */
	public int[][] getAntigens() {
		return antigens;
	}

	/*
	 * To string
	 */
	@Override
	public String toString() {
		String l = "";
		for (int i = 0; i < antigens.length; i++) {
			for (int j = 0; j < antigens[0].length; j++) {
				l += antigens[i][j] + "  ";
			}
			l += "\n";
		}
		return l;
	}
}
