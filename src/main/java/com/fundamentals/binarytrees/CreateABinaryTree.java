package com.fundamentals.binarytrees;

import com.practise.leetcode.TreeNode;

public class CreateABinaryTree {

	
				   /* tree
				    ----
				     1    <-- root
				   /   \
				  2     3  
				 /   
				4*/
	
	
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
	}
}
