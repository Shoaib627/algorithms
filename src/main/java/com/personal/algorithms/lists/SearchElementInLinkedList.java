package com.personal.algorithms.lists;

public class SearchElementInLinkedList {
	
	public static void main(String[] args) {

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4 });

		System.out.println(searchIterative(node, 4));
		System.out.println(searchRecursive(node, 4));
		
		System.out.println(searchIterative(node, 2));
		System.out.println(searchRecursive(node, 2));
		
		System.out.println(searchIterative(node, 1));
		System.out.println(searchRecursive(node, 1));
		
		
		System.out.println(searchIterative(node, 0));
		System.out.println(searchRecursive(node, 0));

		System.out.println(searchIterative(node, 5));
		System.out.println(searchRecursive(node, 5));

	}

	public static boolean searchIterative(ListNode node, int element) {

		if (node == null) {
			return false;
		}

		ListNode current = node;

		while (current != null) {
			if (current.val == element)
				return true;
			current = current.next;
		}
		return false;
	}
	
	
	public static boolean searchRecursive(ListNode node, int element) {

		if (node == null) {
			return false;
		}
		return node.val == element || searchRecursive(node.next, element);
	}
}
