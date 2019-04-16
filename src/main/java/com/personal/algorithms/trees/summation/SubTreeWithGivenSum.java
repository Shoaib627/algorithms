package com.personal.algorithms.trees.summation;

import com.personal.algorithms.leetcode.TreeNode;

public class SubTreeWithGivenSum {

	public Integer getSubTreeWithGiveSum(TreeNode root, int x) {

		if (root == null) {
			return 0;
		}

		Integer left_sum = getSubTreeWithGiveSum(root.left, x);
		Integer right_sum = getSubTreeWithGiveSum(root.right, x);

		int tree_sum = root.val + left_sum + right_sum;

		if (tree_sum == x) {
			System.out.println("YES");
		}

		return tree_sum;

	}

	public static void main(String[] args) {
		
	    TreeNode root = new TreeNode(1);  
	    root.left = new TreeNode(3);  
	    root.right = new TreeNode(6);  
	    root.left.left = new TreeNode(5);  
	    root.left.right = new TreeNode(9);  
	    root.left.right.left = new TreeNode(8);  

	    
	    SubTreeWithGivenSum ll = new SubTreeWithGivenSum();
	    
	    System.out.println(ll.getSubTreeWithGiveSum(root, 17));
	    System.out.println(ll.getSubTreeWithGiveSum(root, 11));

	    

	}
}
