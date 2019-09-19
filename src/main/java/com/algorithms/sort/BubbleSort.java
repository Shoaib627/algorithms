package com.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int A[] = new int[] { 2, 6, 1, 2, 4, -1, -4, 0 };
		sort(A);
		System.out.println(Arrays.toString(A));
	}

	public static int[] sort(int A[]) {

		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < A.length - i - 1; j++) {

				if (A[j] > A[j + 1]) {

					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}

			}
		}

		return A;
	}

}
