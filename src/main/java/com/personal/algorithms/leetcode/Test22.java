package com.personal.algorithms.leetcode;

import java.util.ArrayList;

public class Test22 {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);

		System.out.println(binarySearch(arr, 0, arr.size() - 1, 4));

	}

	public static int binarySearch(ArrayList<Integer> arr, int start, int end, int target) {
		if (start <= end) {

			int mid = start + ((end - start) / 2);

			if (arr.get(mid) == target) {
				return mid;
			}

			else if (arr.get(mid) > target) {
				return binarySearch(arr, start, mid - 1, target);
			}
			return binarySearch(arr, mid + 1, end, target);
		}
		return start;
	}
}