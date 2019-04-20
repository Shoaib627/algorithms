package com.personal.algorithms.leetcode;

import com.personal.algorithms.lists.PrintLinkedList;

public class Test22 {

	public static void main(String[] args) {

		MyLinkedList obj = new MyLinkedList();
	
		PrintLinkedList.printIterative(obj.head);
		
		obj.addAtHead(1);
		obj.addAtTail(3);
		PrintLinkedList.printIterative(obj.head);

		obj.addAtIndex(1,2);
		PrintLinkedList.printIterative(obj.head);

		int param_4 = obj.get(-1);

		obj.deleteAtIndex(1);
		int param_5 = obj.get(-3);




		System.out.println("Done");


	}

}