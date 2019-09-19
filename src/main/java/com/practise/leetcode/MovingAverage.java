package com.practise.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

	Queue<Integer> queue;

	double sum = 0;
	
	int size = 0;

	public MovingAverage(int size) {
		this.queue = new LinkedList<Integer>();
		this.size = size;
	}

	public double next(int val) {
		Integer r = 0;
		queue.add(val);

		if (queue.size() > size) {
			r = queue.poll();
		}


		this.sum = this.sum - r + val;

		return (int)sum / size;

	}
}
