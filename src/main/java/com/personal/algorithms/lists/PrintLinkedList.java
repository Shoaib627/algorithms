package com.personal.algorithms.lists;

public class PrintLinkedList {

	public static void main(String[] args) {

		 ListNode list = LinkedListGenerator.getList(new int[] {1, 2, 3});
		 printRecursive(list);
		 System.out.println();
		 printRecursive(reverse(list));


	}

	public static void printIterative(ListNode node) {

		ListNode cur = node;

		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		
		System.out.println();
	}
	
	public static ListNode reverse(ListNode head) {

		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode result  = null;

		
		while (current != null) {

			ListNode temp = current.next;

			current.next = result;
			result = current;

			current = temp;
		}
		
		return result;
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