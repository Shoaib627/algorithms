package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsIntegerWithDuplicates {

	public static void main(String[] args) {

		permuteUnique(new int[] { 1, 1, 3 });

	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> available = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			available.add(nums[i]);
		}

		permuteHelper(available, new ArrayList<>(), result);
		
		System.out.println(result);
		return new ArrayList<>(result);
	}

	public static void permuteHelper(List<Integer> available, List<Integer> choosen, List<List<Integer>> result) {

		Collections.sort(available);
		if (available.size() == 0) {
			result.add(new ArrayList<>(choosen));
		}
		else {
			for (int i = 0; i < available.size(); i++) {
				
				if (i > 0 && available.get(i - 1) == available.get(i))
					continue;
				
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