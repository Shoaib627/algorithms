package com.personal.algorithms.lists;

public class CountFrequencyOfElementInList {

	public static void main(String[] args) {

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4, 3, 4, 5, 6 });

		System.out.println(countFrequency(node, 0));
		System.out.println(countFrequency(node, 4));

	}

	public static int countFrequency(ListNode node, int val) {

		if (node == null) {
			return 0;
		}

		ListNode current = node;
		int count = 0;
		while (current != null) {
			if (current.val == val) {
				count++;
			}
			current = current.next;
		}
		return count;
	}

}
