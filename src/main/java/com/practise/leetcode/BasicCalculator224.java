package com.practise.leetcode;

import java.util.Stack;

public class BasicCalculator224 {

	public static void main(String[] args) {

		BasicCalculator224 ls = new BasicCalculator224();

		System.out.println(ls.calculate(
				"((((8+3)*(4-10))-2)+((5+(10/2))+((9+5)+(2+2))))"));
		
		//System.out.println(ls.calculate(
		//		"11*-6"));

	}

	public int calculate(String s) {

		s = s.replace(" ", "");
		System.out.println(s);
		Stack<String> values = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != ')') {

				if (Character.isDigit(s.charAt(i))) {
					int num = 0;
					while (i < s.length() && Character.isDigit(s.charAt(i))) {
						num = num * 10 + Character.getNumericValue(s.charAt(i));
						i++;
					}
					i--;
					values.push(String.valueOf(num));
				} else {
					values.push(s.charAt(i) + "");
				}
			}

			else {

				StringBuffer b = new StringBuffer();
				Stack<String> temp = new Stack<>();

				while (!values.isEmpty() && !values.peek().equals("(")) {
					temp.push(values.pop());

				}

				while (!temp.isEmpty()) {
					b.append(temp.pop());
				}

				if (!values.isEmpty() && values.peek().equals("(")) {
					values.pop();
				}

				values.push(String.valueOf(calculateHelper(b.toString())));
			}
		}

		StringBuffer b = new StringBuffer();

		Stack<String> temp = new Stack<>();

		while (!values.isEmpty()) {
			temp.push(values.pop());
		}

		while (!temp.isEmpty()) {
			b.append(temp.pop());
		}

		return calculateHelper(b.toString());

	}

	Node head = null;
	Node curr = null;

	public int calculateHelper(String s) {

		s = s.replace("--", "+").replace("++", "+").replace("-+", "-").replace("+-", "-");
		
		

		head = null;
		curr = null;

		for (int i = 0; i < s.length(); i++) {

			int num = 0;
			boolean is_negative = false;
			
			if (i == 0 && s.charAt(i) == '-') {
				is_negative = true;
				i++;
			}

			else {
				if (i - 1 >= 0 && s.charAt(i) == '-' && (s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-'
						|| s.charAt(i - 1) == '*' || s.charAt(i - 1) == '/')) {
					is_negative = true;
					i++;
				}
			}
			
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				num = num * 10 + Character.getNumericValue(s.charAt(i));
				i++;
			}

			char ch = '0';
			if (i < s.length())
				ch = s.charAt(i);
			
			if(is_negative) {
				num = -num;
			}

			addNode(new Node(num, ch));
		}

		Node itr = head;
		int result = head.value;
		
		while (itr != null) {

			if (itr.op == '/' || itr.op == '*') {

				int num;
				if (itr.op == '/')
					num = itr.value / itr.next.value;
				else
					num = itr.value * itr.next.value;

				result = num;
				itr.value = result;
				itr.op = itr.next.op;

				if (itr.next != null) {
					itr.next = itr.next.next;
				}
			} else {
				itr = itr.next;
			}
		}

		itr = head;

		while (itr != null) {

			if (itr.op == '+' || itr.op == '-') {

				int num;
				if (itr.op == '+')
					num = itr.value + itr.next.value;
				else
					num = itr.value - itr.next.value;

				result = num;
				itr.value = result;
				itr.op = itr.next.op;

				if (itr.next != null) {
					itr.next = itr.next.next;
				}
			} else {
				itr = itr.next;
			}
		}
		System.out.println(result);

		return result;
	}

	class Node {

		int value;

		char op;

		Node next;

		public Node(int val, Character op) {
			this.value = val;
			this.op = op;
		}
	}

	public void addNode(Node node) {
		if (head == null) {
			head = node;
			curr = node;
		} else {
			curr.next = node;
			curr = node;
		}
	}
}
