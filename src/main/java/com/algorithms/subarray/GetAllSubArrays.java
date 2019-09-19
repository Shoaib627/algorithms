package com.algorithms.subarray;

import java.util.ArrayList;
import java.util.List;

public class GetAllSubArrays {
	
	// https://www.youtube.com/watch?v=nwUZkDXXDOg

	public static List<List<Integer>> getAllSubArrays(int[] A) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int start_index = 0; start_index < A.length; start_index++) {

			for (int end_index = start_index; end_index < A.length; end_index++) {

				List<Integer> sub_array = new ArrayList<>();

				for (int i = start_index; i <= end_index; i++) {
					sub_array.add(A[i]);
				}

				result.add(sub_array);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = getAllSubArrays(new int[] { 1, 2, 3, 4, 5 });
		res.forEach(list -> System.out.println(list));
	}
}