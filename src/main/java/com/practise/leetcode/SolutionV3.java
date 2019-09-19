package com.practise.leetcode;

import java.util.Random;

class SolutionV3 {

	int[] arr;

	int sum;

	public SolutionV3(int[] w) {

		this.arr = new int[w.length];

		this.sum = 0;
		for (int i = 0; i < w.length; i++) {

			arr[i] = sum + w[i];
			sum = sum + w[i];
		}

	}

	public int pickIndex() {
		Random s = new Random();
		if (sum == 1)
			return 0;
		return binarySearch(arr, 0, arr.length - 1, s.nextInt(sum - 1) + 1);
	}

	public static int binarySearch(int[] arr, int min, int max, int target) {
		if (min <= max) {

			int mid = min + ((max - min) / 2);

			if (mid - 1 >= 0 && arr[mid] >= target && arr[mid - 1] < target) {
				return mid;
			}

			else if (arr[mid] > target) {
				return binarySearch(arr, min, mid - 1, target);
			}
			return binarySearch(arr, mid + 1, max, target);
		}
		return min;
	}
}
