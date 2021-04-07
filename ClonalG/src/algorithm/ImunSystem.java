package algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class ImunSystem {
	private Vector<Antigen> antigens = new Vector<Antigen>();
	private Vector<Antibody> antibodies = new Vector<Antibody>();
	private int generation = 10;
	private HashMap<Antigen, Antibody> memoryAb = new HashMap<Antigen, Antibody>();

	public ImunSystem(Vector<Antigen> antigens) {
		this.antigens = antigens;
	}

	public void start() {
		int counter = 0;
		while (counter++ <= generation) {
			antibodies = checkAffinity(this.antibodies, this.antigens);
			Vector<Antibody> clonePopulation = prepareAndClone(this.antibodies, this.antigens);
			clonePopulation = mutateClones(clonePopulation);
			clonePopulation = checkAffinity(clonePopulation, this.antigens);
			Collections.sort(clonePopulation, (a, b) -> a.getAffinity() - b.getAffinity());
			this.cloneSelection(clonePopulation);
			Collections.sort(clonePopulation, (a, b) -> a.getAffinity() - b.getAffinity());
			Vector<Antibody> newAntibodies = generateAb(30);
			antibodies = segmentVector(70, antibodies.size(), antibodies);
			for (int i = 0; i < newAntibodies.size(); i++) {
				antibodies.add(newAntibodies.get(i));
			}
		}
	}

	public Vector<Antibody> generateAb(int amount) {
		Vector<Antibody> ab = new Vector<Antibody>();
		for (int i = 0; i < amount; i++) {
			ab.add(new Antibody(antigens.get(0).getAntigens().length, antigens.get(0).getAntigens()[0].length));
		}
		return ab;
	}

	public Vector<Antibody> checkAffinity(Vector<Antibody> antibodies, Vector<Antigen> antigens) {
		for (Antibody ab : antibodies) {
			for (Antigen ag : antigens) {
				ab.countAffinity(ag);
			}
		}
		return antibodies;
	}

	public Vector<Antibody> prepareAndClone(Vector<Antibody> antibodies, Vector<Antigen> antigens) {
		Vector<Antibody> bestAntibodies = new Vector<Antibody>();
		for (Antigen ag : antigens) {
			Vector<Antibody> suitableAb = new Vector<Antibody>();
			for (Antibody ab : antibodies) {
				if (ab.getTargetAntigen().equals(ag)) {
					suitableAb.add(ab);
				}
			}
			Collections.sort(suitableAb, (a, b) -> a.getAffinity() - b.getAffinity());
			suitableAb = segmentVector(4, suitableAb.size(), suitableAb);
			for (int i = 0; i < suitableAb.size(); i++) {
				bestAntibodies.add(suitableAb.get(i));
			}
		}
		return this.clone(bestAntibodies, 10);
	}

	public Vector<Antibody> segmentVector(int i, int f, Vector<Antibody> Antibodies) {
		Vector<Antibody> segAntibodies = new Vector<Antibody>();
		for (int j = i; j < f; j++) {
			segAntibodies.add(Antibodies.get(j));
		}
		return segAntibodies;
	}

	public Vector<Antibody> clone(Vector<Antibody> antibodies, int number) {
		Vector<Antibody> clones = new Vector<Antibody>();
		for (int i = 0; i < antibodies.size(); i++) {
			Antibody antibody = antibodies.get(i);
			antibody.setParentAntibody(antibodies.get(i));
			for (int j = 0; j < number; j++) {
				clones.add(antibody);
			}
		}
		return clones;
	}

	public Vector<Antibody> mutateClones(Vector<Antibody> clonePopulation) {
		Vector<Antibody> clonePopulationP = new Vector<Antibody>();
		for (Antibody clone : clonePopulation) {
			clone.setAntibodies(clone.mutate());
			clonePopulationP.add(clone);
		}
		return clonePopulationP;
	}

	public void cloneSelection(Vector<Antibody> clonePopulation) {
		for (Antigen ag : antigens) {
			for (Antibody clone : clonePopulation) {
				if (clone.getTargetAntigen().getAntigens().equals(ag.getAntigens())) {
					if (clone.getAffinity() < clone.getParentAntibody().getAffinity()) {
						int index = SearchAntibody(clone.getParentAntibody().getAntibodies());
						this.antibodies.set(index, clone);
						addToMemory(ag, clone);
						break;
					} else {
						addToMemory(ag, clone.getParentAntibody());
						break;
					}
				}
			}
		}
	}

	private int SearchAntibody(int[][] AntibodyS) {
		int position = -1;
		for (int i = 0; i < antibodies.size(); i++) {
			if (antibodies.get(i).getAntibodies().equals(AntibodyS)) {
				position = i;
			}
		}
		return position;
	}

	private void addToMemory(Antigen antigen, Antibody antibody) {
		if (this.memoryAb.containsKey(antigen)) {
			Antibody ab = this.memoryAb.get(antigen);
			if (ab.getAffinity() < antibody.getAffinity()) {
				return;
			}
		}
		this.memoryAb.put(antigen, antibody);
	}

	public HashMap<Antigen, Antibody> getMemoryAb() {
		return memoryAb;
	}

	public void setMemoryAb(HashMap<Antigen, Antibody> memoryAb) {
		this.memoryAb = memoryAb;
	}

	public Vector<Antigen> getAntigens() {
		return antigens;
	}

	public void setAntigens(Vector<Antigen> antigens) {
		this.antigens = antigens;
	}

	public Vector<Antibody> getAntibodies() {
		return antibodies;
	}

	public void setAntibodies(Vector<Antibody> antibodies) {
		this.antibodies = antibodies;
	}
}
