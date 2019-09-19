package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Vector2D {

	List<Integer> list;

	Iterator<Integer> it;

	public Vector2D(int[][] v) {

		this.list = new ArrayList<>();

		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				list.add(v[i][j]);
			}
		}

		this.it = list.iterator();

	}

	public int next() {
		return it.next();
	}

	public boolean hasNext() {
		return this.it.hasNext();
	}
}