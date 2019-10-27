package com.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GG {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(25);
		// list.add(90);
		list.add(89);
		list.add(88);
		list.add(91);

		System.out.println(m(list, 90));
		
	}

	public static Integer m(List<Integer> list, int x) {

		if (x < 0 || x > 999) {
			return null;
		}

		if (!list.contains(x)) {
			return 0;
		}

		else {

			int p = -1;
			int q = -1;

			for (int i = x - 1; x >= 0; i--) {
				if (!list.contains(i)) {
					p = i;
					break;
				}
			}

			for (int i = x + 1; x < 1000; i++) {

				if (!list.contains(i)) {
					q = i;
					break;
				}
			}

			if (p == -1 && q == -1) {
				return null;
			}

			if (x - p <= q - x) {
				return p - x;
			}

			else {
				return q - x;
			}
		}
	}
	
	
	
}