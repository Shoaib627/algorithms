package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> available = new ArrayList<>();

		available.add("Sara");
		available.add("Jane");
		available.add("Bob");

		permute(available);

	}

	public static void permute(List<String> available) {

		permuteHelper(available, new ArrayList<>());
	}

	public static void permuteHelper(List<String> available, List<String> choosen) {

		if (available.isEmpty()) {
			System.out.println(choosen);
		}

		else {
			for (int i = 0; i < available.size(); i++) {

				// choose;

				String element = available.get(i);
				choosen.add(element);
				available.remove(i);

				// explore

				permuteHelper(available, choosen);

				// unchoose
				choosen.remove(choosen.size() - 1);
				available.add(i, element);

			}
		}

	}

}
