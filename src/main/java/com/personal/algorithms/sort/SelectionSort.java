package com.personal.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int A[] = new int[] { 2, 6, 1, 2, 4, -1, -4, 0 };
		sort(A);
		System.out.println(Arrays.toString(A));
	}

	
	
/*	
    The selection sort algorithm works in a very simple way. 
    It maintains two subarray for the given array.

	The subarray is already sorted.
	And the second subarray is unsorted.
	With every iteration of selection sort, 
	minimum element is picked from the unsorted subarray and moved to the sorted subarray.
*/

	/*
	        Best:    O(n^2)
			Average: O(n^2)
			Worst:   O(n^2)
     */
			
	public static int[] sort(int A[]) {

		for (int start_index = 0; start_index < A.length; start_index++) {

			int min_index = start_index;

			for (int j = start_index + 1; j < A.length; j++) {

				if (A[j] < A[min_index]) {
					min_index = j;
				}
			}

			int temp = A[start_index];
			A[start_index] = A[min_index];
			A[min_index] = temp;
		}

		return A;
	}
}