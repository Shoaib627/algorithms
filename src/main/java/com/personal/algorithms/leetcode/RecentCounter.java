package com.personal.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

	private Queue<Integer> q;

	public RecentCounter() {

		q = new LinkedList<>();
	}

	public int ping(int t) {

		while (q.peek()!=null && t - q.peek() > 3000) {
			q.poll();
		}

		q.add(t);

		return q.size();

	}
}
