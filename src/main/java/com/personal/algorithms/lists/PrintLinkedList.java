package com.personal.algorithms.lists;

public class PrintLinkedList {

	public static void main(String[] args) {

		printIterative(LinkedListGenerator.getList());
		System.out.println();
		printRecursive(LinkedListGenerator.getList());
		
		System.out.println();
		printRecursive(LinkedListGenerator.getList(new int[] {1, 2, 3}));


	}

	public static void printIterative(ListNode node) {

		ListNode cur = node;

		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		
		System.out.println();
	}
	
	public static void printRecursive(ListNode node) {

		ListNode cur = node;

		if (cur == null) {
			return;
		}
		System.out.print(cur.val + " ");
		printRecursive(node.next);
	}
}