package com.personal.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> available = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			available.add(nums[i]);
		}

		permuteHelper(available, new ArrayList<>(), result);
		return result;
	}

	public void permuteHelper(List<Integer> available, List<Integer> choosen, List<List<Integer>> result) {

		if (available.size() == 0) {
			result.add(new ArrayList<>(choosen));
		}
		else {
			for (int i = 0; i < available.size(); i++) {
				Integer element = available.get(i);
				choosen.add(element);
				available.remove(i);

				permuteHelper(available, choosen, result);

				choosen.remove(choosen.size() - 1);
				available.add(i, element);
			}
		}
	}
}