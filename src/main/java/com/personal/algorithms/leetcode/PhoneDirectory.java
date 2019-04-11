package com.personal.algorithms.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class PhoneDirectory {

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers - The maximum numbers that can be stored in the phone
	 *                   directory.
	 */

	private Map<Integer, Integer> map;
	private int maxNumbers;
	private int counter;
	private LinkedList<Integer> released_array;

	public PhoneDirectory(int maxNumbers) {
		map = new HashMap<>();
		released_array = new LinkedList<>();
		this.maxNumbers = maxNumbers;
		this.counter = 0;
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {

		if (map.size() >= maxNumbers) {
			return -1;
		} else {

			if (released_array.size() > 0) {
				Integer c = released_array.getFirst();

				released_array.removeFirst();

				map.put(c, 1);
				return c;
			}

			else {

				counter++;
				map.put(counter, 1);
				return counter;
			}

		}
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return !map.containsKey(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (map.containsKey(number)) {
			map.remove(number);
			released_array.addFirst(number);
			;
		}
	}
}