package com.practise.leetcode;

public class BasicCalculator {

	public static void main(String[] args) {

		BasicCalculator ls = new BasicCalculator();

		System.out.println(ls.calculate("5*3"));

	}

	Node head = null;
	Node curr = null;

	public int calculate(String s) {
		
		
		head = null;
		 curr = null;
		
		System.out.println(s);

		s = s.replace(" ", "");

		for (int i = 0; i < s.length(); i++) {

			int num = 0;
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				num = num * 10 + Character.getNumericValue(s.charAt(i));
				i++;
			}

			char ch = '0';
			if (i < s.length())
				ch = s.charAt(i);

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
