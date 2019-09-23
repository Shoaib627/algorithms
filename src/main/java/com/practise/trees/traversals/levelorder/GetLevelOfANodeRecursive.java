package com.practise.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class GetLevelOfANodeRecursive {

	
	public int getLevel(TreeNode root, int x) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		int level = 1;
		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {

				level++;
				
				if (q.isEmpty()) {
					return 0;
				}

				else {
					q.add(null);
				}
			} else {
				
				if(node.val == x) {
					return level;
				}

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
		return 0;

	}
	
	
	public static void main(String[] args) {
		
		GetLevelOfANodeRecursive ll = new GetLevelOfANodeRecursive();
		System.out.println(ll.getLevel(TreeGenerator.getTree(), 7));
		System.out.println(ll.getLevel(TreeGenerator.getTree(), 2));
		System.out.println(ll.getLevel(TreeGenerator.getTree(), 1));


	}

}
