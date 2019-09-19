package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

	public Stack<Integer> stack;

	public Stack<Integer> temp_stack;

	public Map<Integer, Integer> frequency_map;

	public Integer max_frequency;

	public FreqStack() {

		this.stack = new Stack<>();
		this.temp_stack = new Stack<>();
		this.frequency_map = new HashMap<>();
		this.max_frequency = 0;
	}

	public void push(int x) {

		stack.push(x);
		Integer c = frequency_map.get(x);
		frequency_map.put(x, c != null ? c + 1 : 1);

		updateFrequentElement();
	}

	public int pop() {
		Integer t = 0;
		while (frequency_map.get(stack.peek()) <= max_frequency) {

			if (frequency_map.get(stack.peek()) == max_frequency) {
				t = stack.pop();
				break;
			}

			else
				temp_stack.push(stack.pop());
		}

		while (!temp_stack.isEmpty()) {
			stack.push(temp_stack.pop());
		}

		Integer c = frequency_map.get(t);
		frequency_map.put(t, c - 1);

		updateFrequentElement();

		return t;
	}

	public void updateFrequentElement() {
		Integer max = 0;

		for (Map.Entry<Integer, Integer> entry : frequency_map.entrySet()) {

			if (entry.getValue() > max) {
				max = entry.getValue();
				max_frequency = entry.getValue();
			}
		}
	}
}
