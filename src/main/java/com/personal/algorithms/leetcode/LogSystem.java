package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LogSystem {

	Map<String, Integer> map;

	Map<String, String> mapV2;

	Map<String, String> mapV3;

	NavigableMap<String, List<Integer>> logs;

	public LogSystem() {

		this.map = new HashMap<String, Integer>();
		this.mapV2 = new HashMap<String, String>();
		this.mapV3 = new HashMap<String, String>();

		map.put("Year", 4);
		map.put("Month", 7);
		map.put("Day", 10);
		map.put("Hour", 13);
		map.put("Minute", 16);

		mapV2.put("Year", ":12:31:23:59:59");
		mapV2.put("Month", ":31:23:59:59");
		mapV2.put("Day", ":23:59:59");
		mapV2.put("Hour", ":59:59");
		mapV2.put("Minute", ":59");

		mapV3.put("Year", ":00:00:00:00:00");
		mapV3.put("Month", ":00:00:00:00");
		mapV3.put("Day", ":00:00:00");
		mapV3.put("Hour", ":00:00");
		mapV3.put("Minute", ":00");

		logs = new TreeMap<>();
	}

	public void put(int id, String timestamp) {
		List<Integer> list = logs.getOrDefault(timestamp, new ArrayList<>());
		list.add(id);
		logs.put(timestamp, list);
	}

	public List<Integer> retrieve(String s, String e, String gra) {
		
		String start;
		String end;
			
		if (!gra.equals("Second")) {
			start = s.substring(0, map.get(gra)) + mapV3.get(gra);
			end = e.substring(0, map.get(gra)) + mapV2.get(gra);
		} else {
			start = s;
			end = e;
		}

		List<Integer> r = new ArrayList<>();
		for(List<Integer> log : logs.subMap(start, true, end, true).values()) {
			r.addAll(log);
		}
		
		return r;
	}
}
