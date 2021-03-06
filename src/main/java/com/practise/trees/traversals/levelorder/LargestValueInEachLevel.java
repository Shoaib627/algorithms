package com.practise.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class LargestValueInEachLevel {

	public void largestValue(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		Integer max_so_far = null;

		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {

				System.out.print(max_so_far + " ");
				max_so_far = null;
				
				if (q.isEmpty()) {
					return;
				}

				else {
					q.add(null);
				}
			} else {
				
				if (max_so_far == null) {
					max_so_far = node.val;
				}

				else {
					if (node.val > max_so_far) {
						max_so_far = node.val;
					}
				}

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
		}

	}

	public static void main(String[] args) {
		LargestValueInEachLevel ll = new LargestValueInEachLevel();
		ll.largestValue(TreeGenerator.getTree());

	}
}