package com.personal.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {

	private Map<String, Set<String>> map;

	private Map<String, String> smap;

	public ValidWordAbbr(String[] dictionary) {

		this.map = new HashMap<>();
		this.smap = new HashMap<>();

		for (int i = 0; i < dictionary.length; i++) {
			String str = getAbbr(dictionary[i]);
			Set<String> list = map.getOrDefault(str, new HashSet<>());
			list.add(dictionary[i]);
			map.put(str, list);
			smap.put(dictionary[i], str);
		}

	}

	public boolean isUnique(String word) {

		if (smap.containsKey(word)) {
			return map.get(smap.get(word)).size() == 1;
		}

		else {
			return map.get(getAbbr(word)) == null;
		}
	}

	public String getAbbr(String str) {
		if (str.length() > 2) {
			StringBuffer b = new StringBuffer();
			b.append(String.valueOf(str.charAt(0)) + String.valueOf(str.length() - 2)
					+ String.valueOf(str.charAt(str.length() - 1)));
			return b.toString();
		}
		return str;
	}
}