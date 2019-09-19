package com.practise.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


class SnapshotArray {

	Map<Integer, Map<Integer, Integer>> map;

	Map<Integer, LinkedList<Integer>> snap_map;

	int snap;

	public SnapshotArray(int length) {
		map = new HashMap<>();
		snap_map = new HashMap<>();
		snap = 0;
	}

	public void set(int index, int val) {

		if (snap_map.containsKey(index)) {

			LinkedList<Integer> list = snap_map.get(index);

			if (list.getLast() != val) {
				list.addLast(snap);
				snap_map.put(index, list);

			}

			Map<Integer, Integer> m = map.get(index);
			m.put(snap, val);
			map.put(index, m);

		} else {
			LinkedList<Integer> list = new LinkedList<>();
			list.addLast(snap);
			snap_map.put(index, list);

			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			m.put(snap, val);
			map.put(index, m);

		}

	}

	public int snap() {

		int temp = snap;
		snap++;
		return temp;
	}

	public int get(int index, int snap_id) {

		if (!map.containsKey(index)) {
			return 0;
		}

		if (map.get(index).containsKey(snap_id)) {
			return map.get(index).get(snap_id);
		}

		else {
			LinkedList<Integer> list = snap_map.get(index);

			if (list.isEmpty()) {
				return 0;
			}

			if (snap_id >= list.getLast()) {
				return map.get(index).get(list.getLast());

			} else if (snap_id <= list.getFirst()) {
				return 0;
			}

			else {

				// aim is to find intersection point
				int i = Collections.binarySearch(list, snap_id);

				int j = 0;

				if (i >= 0) {
					j = i;
				} else {
					j = Math.abs(Math.abs(i) - 1);
					j = j - 1;
				}
				return map.get(index).get(list.get(j));
			}

		}
	}
}