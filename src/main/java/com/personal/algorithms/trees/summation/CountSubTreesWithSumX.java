package com.personal.algorithms.trees.summation;

import com.personal.algorithms.leetcode.TreeNode;

public class CountSubTreesWithSumX {
	
	
	private Integer count = 0;
	
	
	public Integer sum(TreeNode root, Integer X) {
		
		if(root == null) {
			return 0;
		}
		
		Integer left = sum(root.left, X);
		Integer right = sum(root.right, X);
		
		int tree_sum = root.val + left + right;
		if(tree_sum == X) {
			count ++;
		}
		return tree_sum;
	}

	public static void main(String[] args) {

		CountSubTreesWithSumX c = new CountSubTreesWithSumX();
		
	    TreeNode root = new TreeNode(5);  
	    root.left =  new TreeNode(-10);  
	    root.right =  new TreeNode(3);  
	    root.left.left =  new TreeNode(9);  
	    root.left.right =  new TreeNode(8);  
	    root.right.left =  new TreeNode(-4);  
	    root.right.right =  new TreeNode(7);  
	    
	    c.sum(root, 7);
	    
	    System.out.println(c.count);
				
	}
}