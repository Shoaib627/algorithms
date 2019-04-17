package com.personal.algorithms.leetcode;

import java.util.ArrayList;

class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
	
	private int[] arr;
	
	private int front ;
	
	private int rear ;

	public MyCircularQueue(int k) {
		this.arr = new int[k];
		this.front = -1;
		this.rear = -1;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {

		if (isFull())
			return false;

		this.rear += 1;

		arr[this.rear] = value;

		return true;
	}
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
		return false;
        
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return this.front;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return this.rear;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
		return false;
        
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
		return false;
        
    }
}