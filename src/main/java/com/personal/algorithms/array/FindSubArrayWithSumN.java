package com.personal.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubArrayWithSumN {

	// https://www.youtube.com/watch?v=HJDlxZNe1UI
	// https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
	
	
	public static List<List<Integer>> findSubArrayWithSumN(int[] A, int sum) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int start_index = 0; start_index < A.length; start_index++) {

			for (int end_index = start_index; end_index < A.length; end_index++) {

				List<Integer> sub_array = new ArrayList<>();

				int local_sum = 0;
				for (int i = start_index; i <= end_index; i++) {
					local_sum += A[i];
					sub_array.add(A[i]);

					
				}

				if(local_sum == sum) {
					result.add(sub_array);
				}
			}
		}
		return result;
	}
	
	public static List<List<Integer>> findSubArrayWithSumNV2(int[] A, int sum) {

		Map<Integer, Integer> map = new HashMap<>();

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		int current_sum = 0;
		for (int i = 0; i < A.length; i++) {
			current_sum = current_sum + A[i];

			if (current_sum == sum) {

				List<Integer> range = new ArrayList<>();
				range.add(0);
				range.add(i);

				result.add(range);

				//continue;
			}

			else if (map.containsKey(current_sum - sum)) {

				List<Integer> range = new ArrayList<>();
				range.add(map.get(current_sum - sum) + 1);
				range.add(i);
				result.add(range);

				//continue;
			}

			map.put(current_sum, i);
		}
		return result;
	}
	
	public static int subarraySum(int[] A, int sum) {

		int count = 0;
		for (int start_index = 0; start_index < A.length; start_index++) {

			for (int end_index = start_index; end_index < A.length; end_index++) {


				int local_sum = 0;
				for (int i = start_index; i <= end_index; i++) {
					local_sum += A[i];
				}

				if (local_sum == sum) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = findSubArrayWithSumNV2(new int[] { 1, 1, 1, 0,2}, 2);
		res.forEach(list -> System.out.println(list));
		
		res = findSubArrayWithSumNV2(new int[] { 1, 2, 3, 4, 5, 10 }, 10);
		//res.forEach(list -> System.out.println(list));
	}
	
	
	
	
}
