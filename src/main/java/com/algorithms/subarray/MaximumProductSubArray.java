package com.algorithms.subarray;

public class MaximumProductSubArray {

	public static int maximumProductSubArray(int[] A) {

		int current_min_product = A[0];
		int current_max_product = A[0];

		int previous_min_product = A[0];
		int previous_max_product = A[0];

		int ans = A[0];

		for (int i = 1; i < A.length; i++) {

			current_max_product = Math.max(previous_max_product * A[i], Math.max(previous_min_product * A[i], A[i]));
			current_min_product = Math.min(previous_max_product * A[i], Math.min(previous_min_product * A[i], A[i]));

			ans = Math.max(ans, current_max_product);
			previous_max_product = current_max_product;
			previous_min_product = current_min_product;

		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(maximumProductSubArray(new int[] { 1, 2, 3, 4, -5 }));
	}
}
