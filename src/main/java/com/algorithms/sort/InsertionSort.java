package com.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int A[] = new int[] { 2, 6, 1, 2, 4, -1, -4, 0 };
		sort(A);
		System.out.println(Arrays.toString(A));
	}

	public static int[] sort(int A[]) {

		for (int i = 1; i < A.length; i++) {

			int key = A[i];
			int j = i - 1;

			while (j >= 0 && A[j] > key) {

				A[j + 1] = A[j];
				j--;
			}

			A[j + 1] = key;
		}

		return A;
	}
}