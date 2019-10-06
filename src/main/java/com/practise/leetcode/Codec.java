package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {

		return String.join("______XYZ______", strs);
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		
		System.out.println(s);
		return s.length() == 0 ? new ArrayList<String>() : Arrays.asList(s.split("______XYZ______"));
	}
}