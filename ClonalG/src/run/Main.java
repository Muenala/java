package run;

import java.util.Vector;

import algorithm.Antibody;
import algorithm.Antigen;
import algorithm.ImunSystem;

public class Main {

	public static void main(String[] args) {
		int[][] symbol1 = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		int[][] symbol2 = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 } };
		int[][] symbol3 = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };
		Vector<Antigen> antigens = new Vector<Antigen>();
		antigens.add(new Antigen(symbol1));
		antigens.add(new Antigen(symbol2));
		antigens.add(new Antigen(symbol3));
		ImunSystem system = new ImunSystem(antigens);
		system.start();
		showResults(system);
	}

	private static void showResults(ImunSystem system) {
		System.out.println("--------------Antigen---------------");
		for (Antigen ag : system.getMemoryAb().keySet()) {
			System.out.println("Antigen:\n" + ag.toString());
		}
		System.out.println("-------------Antibody---------------");
		for (Antibody ab : system.getMemoryAb().values()) {
			System.out.println("Antibody:\n" + ab.toString());
		}
	}
}
