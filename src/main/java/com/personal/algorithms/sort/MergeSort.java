package com.personal.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int A[] = new int[] { 2, 6, 1, 2, 4, -1, -4, 0, 23, -23 };
		sort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}

	public static int[] sort(int A[], int p, int r) {

		if (p < r) {
			int q = (p + r) / 2;
			sort(A, p, q);
			sort(A, q + 1, r);
			merge(A, p, q, r);
		}

		return A;
	}

	public static void merge(int A[], int p, int q, int r) {

		int[] left = new int[q - p + 1];

		int[] right = new int[r - q];

		for (int i = 0; i < q - p + 1; i++) {
			left[i] = A[p + i];
		}

		for (int i = 0; i < r - q; i++) {
			right[i] = A[q + 1 + i];
		}

		int i = 0;
		int j = 0;

		int k = p;

		while (i < left.length && j < right.length) {

			if (left[i] < right[j]) {

				A[k] = left[i];
				i++;
			}

			else {
				A[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < left.length) {
			A[k] = left[i];
			i++; k++;
		}

		while (j < right.length) {
			A[k] = right[j];
			j++; k++;
		}
	}
}