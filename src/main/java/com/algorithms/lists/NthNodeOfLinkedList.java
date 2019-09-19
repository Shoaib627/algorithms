package com.algorithms.lists;

public class NthNodeOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4 });

		System.out.println(NthNodeOfList(node, 0));

		System.out.println(NthNodeOfList(node, 1));
		System.out.println(NthNodeOfList(node, 2));
		System.out.println(NthNodeOfList(node, 3));
		System.out.println(NthNodeOfList(node, 4));

		System.out.println(NthNodeOfList(node, 5));

	}

	public static int NthNodeOfList(ListNode node, int n) {
		if (node == null)
			return -1;

		ListNode current = node;
		int pos = 1;

		while (current != null) {

			if (pos == n) {
				return current.val;
			}
			current = current.next;

			pos++;

		}
		return -1;
	}

}
