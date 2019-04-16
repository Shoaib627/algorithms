package com.personal.algorithms.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	
	public MedianFinder() {

		 this.minHeap = new PriorityQueue<>();
		 this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	}
    
    public void addNum(int num) {
    	
    	if(minHeap.isEmpty() && maxHeap.isEmpty()) {
    		minHeap.add(num);
    	}
        
    	else if (!maxHeap.isEmpty() && num > maxHeap.peek()) {
			minHeap.add(num);
		}
		
		else if(!minHeap.isEmpty() && num < minHeap.peek()) {
			maxHeap.add(num);
		}
		
		else {
			minHeap.add(num);
		}
    	
		if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
			balance();
		}
    }
    
	public double findMedian() {

		if (minHeap.size() == maxHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();

	}
    
	private void balance() {
		
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
		
		else {
			minHeap.add(maxHeap.poll());
		}

	}
}
