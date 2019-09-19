package com.practise.leetcode;

import java.util.HashMap;

public class Logger {

	HashMap<String, Integer> map;

	public Logger() {
		map = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		
		Integer time = map.get(message);
		if(time == null) {
			map.put(message, timestamp);
			return true;
		}
		
		else {
			if( timestamp - time < 10) {
				return false;
			}
			else {
				map.put(message, timestamp);
				return true;
			}
		}

	}
	

}