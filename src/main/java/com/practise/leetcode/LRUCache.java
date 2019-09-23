package com.practise.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);

		c.put(2, 1);
		c.put(2, 2);
		c.get(2);
		c.put(3, 3);
		c.get(2);
		c.put(4, 4);
		c.get(1);
		c.get(3);
		c.get(4);
	}

	LinkedList<Integer> list;

	int capacity;

	Map<Integer, Integer> map;

	public LRUCache(int capacity) {
		list = new LinkedList<>();
		this.capacity = capacity;
		this.map = new HashMap<Integer, Integer>();
	}

	public int get(int key) {
		Integer k = map.get(key);
		if (k != null) {
			list.removeLastOccurrence(key);
			list.addFirst(key);
			return k;
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			list.removeLastOccurrence(key);
			list.addFirst(key);
			map.put(key, value);

			return;
		}

		if (map.size() == capacity) {
			map.remove(list.removeLast());
		}

		map.put(key, value);
		list.addFirst(key);
	}
}