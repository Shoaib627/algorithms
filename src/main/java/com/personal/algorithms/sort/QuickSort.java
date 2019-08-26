package com.personal.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {

		int A[] = new int[] { 2, 6, 1, 2, 4, -1, -4, 0, 23, -23, 89, 87, 7, -6 };
		sort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}

	// Pick A Pivot, Partition, & Recurse
	public static void sort(int[] A, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivot = randomizedPartition(A, start, end);

		sort(A, start, pivot - 1);
		sort(A, pivot + 1, end);
	}

	// At any stage all elements to the left of
	// partition index will be lesser than the pivot element.

	public static int partition(int[] A, int start, int end) {

		int pivot = A[end];
		int parition_index = start;

		for (int i = start; i < end; i++) {

			if (A[i] <= pivot) {
				swap(A, i, parition_index);
				parition_index++;
			}
		}
		swap(A, end, parition_index);
		return parition_index;

	}

	public static int randomizedPartition(int[] A, int start, int end) {

		int pivot_index = new Random().nextInt(end - start) + start;
		swap(A, pivot_index, end);

		return partition(A, start, end);

	}

	public static void swap(int A[], int i, int j) {

		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}