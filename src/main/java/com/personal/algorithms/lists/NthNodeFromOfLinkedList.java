package com.personal.algorithms.lists;

public class NthNodeFromOfLinkedList {

	public static void main(String[] args) {
	
		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4, 5, 6 });
		
		System.out.println(NthNodeFromEndOfList(node, 0));
		System.out.println(NthNodeFromEndOfList(node, 1));

		System.out.println(NthNodeFromEndOfList(node, 2));
		System.out.println(NthNodeFromEndOfList(node, 3));


		System.out.println(NthNodeFromEndOfList(node, 4));
		System.out.println(NthNodeFromEndOfList(node, 5));
		
		System.out.println(NthNodeFromEndOfList(node, 6));
		System.out.println(NthNodeFromEndOfList(node, 7));

	}

	public static int NthNodeFromEndOfList(ListNode node, int n) {
		if (node == null)
			return -1;

		ListNode current = node;

		int length = 0;

		while (current != null) {

			current = current.next;

			length++;

		}

		int pos = 1;
		int k = length - n + 1;
		current = node;
		if (k > 0) {

			while (current != null) {

				if (pos == k) {
					return current.val;
				}
				current = current.next;

				pos++;

			}
		}
		return -1;
	}
}