package com.personal.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {

		subsets(new int[] { 1, 2, 3 });
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> result, List<Integer> choosen, int[] available, int start) {
		result.add(new ArrayList<>(choosen));
		System.out.println("********Choosen*****************  " + choosen + "        *****Available****** "
				+ Arrays.toString(available));
		for (int i = start; i < available.length; i++) {
			choosen.add(available[i]);
			backtrack(result, choosen, available, i + 1);
			choosen.remove(choosen.size() - 1);
		}
	}

}
