package com.practise.leetcode;

import java.util.Stack;

class Solution {

	public NestedInteger deserialize(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != ']') {
				stack.push(s.charAt(i));
			}

			else {
				while (stack.peek() == '[') {

				}
			}
		}

		int start_index = 0;
		while (start_index < s.length()) {

		}

		return null;
	}
}