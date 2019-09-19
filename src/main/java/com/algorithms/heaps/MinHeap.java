package com.algorithms.heaps;

import java.util.Arrays;

public class MinHeap {

	// Left Child : (2p + 1)
	// Right Child : (2p + 2)
	// Parent : (i - 1)/2

	private int capacity;

	private int size;

	private int[] heap;

	public MinHeap(int capacity, int size, int[] heap) {
		super();
		this.capacity = 10;
		this.size = 0;
		this.heap = new int[capacity];
	}

	public void insert(int x) {

	}

	public void remove() {

	}

	public boolean hasLeftChild(int index) {
		return (2 * index + 1) >= size;
	}

	public boolean hasRightChild(int index) {
		return (2 * index + 2) >= size;
	}

	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	public int getLeftChildIndex(int index) {
		return (2 * index + 1);
	}

	public int getRightChildIndex(int index) {
		return (2 * index + 2);
	}

	public int getParent(int index) {
		return heap[(index - 1) / 2];
	}

	public int getLeftChild(int index) {
		return heap[(2 * index + 1)];
	}

	public int getRightChild(int index) {
		return heap[(2 * index + 2)];
	}

	public void ensureMoreCapacity() {
		capacity = capacity * 2;
		heap = Arrays.copyOf(heap, capacity);
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

}