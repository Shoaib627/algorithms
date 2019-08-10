package com.personal.algorithms.spoj;

import java.util.Stack;

public class ONP {

	public static void main(String[] args) {

		System.out.println(getRNP("(a+(b*c))"));

	}

	public static String getRNP(String str) {

		char[] arr = str.toCharArray();

		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {

			char ch = arr[i];

			if (ch == '-' || ch == '*' || ch == '/' || ch == '^') {
				stack2.add(ch);
			}

			else if (ch == ')') {

				StringBuffer intermediate = new StringBuffer();
				while (!stack1.isEmpty()) {

					Character e = stack1.pop();

					if (e == '(') {
						intermediate.reverse();
						if (!stack2.isEmpty())
							intermediate.append(stack2.pop());
						result.append(intermediate);
						break;
					}

					else {
						intermediate.append(e);
					}

				}

			}

			else {
				stack1.add(ch);
			}
		}

		return result.toString();
	}

}
