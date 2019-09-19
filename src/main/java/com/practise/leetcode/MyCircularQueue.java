package com.practise.leetcode;

class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
	
	private int[] arr;
	
	private int front ;
	
	private int rear ;
	
	private int size;

	public MyCircularQueue(int k) {
		this.arr = new int[k];
		this.front = -1;
		this.rear = -1;
		this.size = k;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {

		if (isFull())
			return false;
		
		if(isEmpty()) {
			this.rear = 0;
			this.front = 0;
		}

		this.rear = (this.rear + 1 + size) % size;
		
		System.out.println(this.rear);

		arr[this.rear] = value;

		return true;
	}
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	
    	if(isEmpty())
			return false;
    	
		
		else if(this.front == this.rear) {
			this.front = -1;
			this.rear = -1;
		}

		else {
			this.front = (this.front + 1 + size) % size;

		}
		return true;
        
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty())
			return -1;
        return this.front;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty())
			return -1;
        return this.rear;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
		return this.front == -1 && this.rear == -1;
        
    }
    
    /** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return (this.rear + 1 + size) % size == this.front;
	}
}