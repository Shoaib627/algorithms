package com.personal.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetsV2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

	}

	public static void printSubSets(List<String> available) {
		List<String> choosen = new ArrayList<>();
		printSubSets(available, choosen);
	}

	public static void printSubSets(List<String> available, List<String> choosen) {

		System.out.println("********* Avaialble *********  " + available + " ********Choosen***********  " + choosen);

		if (available.isEmpty()) {
			System.out.println(choosen);
		} else {

			String element = available.get(0);
			available.remove(0);
			choosen.add(element);

			printSubSets(available, choosen);

			choosen.remove(choosen.size() - 1);

			printSubSets(available, choosen);

			available.add(0, element);

		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> available = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			available.add(nums[i]);
		}

		Collections.sort(available);

		subsetsHelper(available, new ArrayList<>(), result, target);

		System.out.println(result);

		return result;
	}

	public static void subsetsHelper(List<Integer> available, List<Integer> choosen, List<List<Integer>> result,
			Integer target) {

		if (available.isEmpty()) {
			int sum = 0;
			for (int i = 0; i < choosen.size(); i++) {
				sum += choosen.get(i);
			}
			if (sum == target)
				result.add(new ArrayList<>(choosen));
		} else {

			Integer element = available.get(0);
			available.remove(0);
			choosen.add(element);

			subsetsHelper(available, choosen, result, target);

			choosen.remove(choosen.size() - 1);

			subsetsHelper(available, choosen, result, target);

			available.add(0, element);

		}
	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> available = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			available.add(nums[i]);
		}

		subsetsHelperV2(available, new ArrayList<>(), result, target);
		return result;

	}

	public static void subsetsHelperV2(List<Integer> available, List<Integer> choosen, List<List<Integer>> result,
			int target) {

		if (target == 0) {
			result.add(new ArrayList<>(choosen));

		} else if (target < 0 || available.isEmpty()) {
			return;
		} else {

			Integer element = available.get(0);
			available.remove(0);
			choosen.add(element);

			subsetsHelperV2(available, choosen, result, target - element);

			choosen.remove(choosen.size() - 1);

			subsetsHelperV2(available, choosen, result, target);

			available.add(0, element);

		}
	}
}