package com.practise.leetcode;

import java.util.List;

public class ZigzagIterator {

	private List<Integer> v1;

	private List<Integer> v2;

	int i;

	int j;

	boolean getV1 = true;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

		this.v1 = v1;
		this.v2 = v2;

		this.i = 0;
		this.j = 0;
	}

	public int next() {

		if (i >= v1.size() && j < v2.size()) {

			int temp = v2.get(j);
			j++;
			return temp;
		}

		else if (j >= v2.size() && i < v1.size()) {

			int temp = v1.get(i);
			i++;
			return temp;
		}

		else {
			int temp;
			if (getV1) {
				temp = v1.get(i);
				i++;
			}

			else {
				temp = v2.get(j);
				j++;
			}
			getV1 = !getV1;
			
			System.out.println(temp);

			return temp;
		}

	}

	public boolean hasNext() {
		return i >= v1.size() && j >= v2.size();
	}
}