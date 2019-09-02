package com.personal.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

	Map<String, Integer> map;

	public FileSystem() {
		map = new HashMap<String, Integer>();
	}

	public boolean createPath(String path, int value) {

		int index = path.lastIndexOf("/");

		if (index == 0) {
			map.put(path, value);
			return true;
		}

		else {
			if (map.containsKey(path.subSequence(0, index))) {
				map.put(path, value);
				return true;
			}

			else {
				return false;
			}
		}
	}

	public int get(String path) {
		
		return map.getOrDefault(path, -1);
	}
}
