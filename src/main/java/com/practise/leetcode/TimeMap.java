package com.practise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeMap {

	
	private Map<String, Map<Integer, String>> map;
	
	private Map<String, ArrayList<Integer>> timestamps;
	
    public TimeMap() {
        
    	this.map = new HashMap<>();
    	this.timestamps = new HashMap<>();

    }
    
	public void set(String key, String value, int timestamp) {

		Map<Integer, String> t = map.getOrDefault(key, new HashMap<>());
		t.put(timestamp, value);
		map.put(key, t);

		ArrayList<Integer> list = timestamps.getOrDefault(key, new ArrayList<>());
		list.add(timestamp);

		timestamps.put(key, list);

	}
    
	public String get(String key, int timestamp) {

		if (map.containsKey(key)) {

			ArrayList<Integer> tlist = timestamps.get(key);

			if (tlist == null || tlist.isEmpty()) {
				return "";
			}

			int index = binarySearch(tlist, 0, tlist.size() - 1, timestamp);
			
			if (index >= tlist.size() || tlist.get(index) > timestamp) {
				index = index - 1;
			}

			
			if (index < 0) {
				return "";
			}

			return map.get(key).get(tlist.get(index));

		}

		return "";
	}
	
	
	public static int binarySearch(ArrayList<Integer> arr, int start, int end, int target) {
		if (start <= end) {

			int mid = start + ((end - start) / 2);

			if (arr.get(mid) == target) {
				return mid;
			}

			else if (arr.get(mid) > target) {
				return binarySearch(arr, start, mid - 1, target);
			}
			return binarySearch(arr, mid + 1, end, target);
		}
		return start;
	}
	 
}
