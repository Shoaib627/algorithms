package com.algorithms.subarray;

public class SumOfSubArrays {

	// https://algorithms.tutorialhorizon.com/sum-of-all-sub-arrays-in-on-time/
	
	public static int sumOfAllSubArrays(int[] A) {

		int sum = 0;
		for (int start_index = 0; start_index < A.length; start_index++) {

			for (int end_index = start_index; end_index < A.length; end_index++) {

				for (int i = start_index; i <= end_index; i++) {
					sum += A[i];
				}

			}
		}
		return sum;
	}
	
	
	public static int sumOfAllSubArraysV2(int[] A) {

		int sum = 0;
		int n = A.length;
		for (int i = 0; i < A.length; i++) {

			sum += ((n - i) + i * (n - i)) * A[i];
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		System.out.println(sumOfAllSubArraysV2(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(sumOfAllSubArrays(new int[] { 1, 2, 3, 4, 5 }));

		
	}
}
