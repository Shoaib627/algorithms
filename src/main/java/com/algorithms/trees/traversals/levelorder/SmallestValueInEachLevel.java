package com.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class SmallestValueInEachLevel {


	public void smallestValue(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		Integer min_so_far = null;

		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {

				System.out.print(min_so_far + " ");
				min_so_far = null;
				
				if (q.isEmpty()) {
					return;
				}

				else {
					q.add(null);
				}
			} else {
				
				if (min_so_far == null) {
					min_so_far = node.val;
				}

				else {
					if (node.val < min_so_far) {
						min_so_far = node.val;
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
		SmallestValueInEachLevel ll = new SmallestValueInEachLevel();
		ll.smallestValue(TreeGenerator.getTree());
	}
}