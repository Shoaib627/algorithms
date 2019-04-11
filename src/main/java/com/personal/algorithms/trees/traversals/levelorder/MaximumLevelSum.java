package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;

public class MaximumLevelSum {

	public int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		Integer max_sum = Integer.MIN_VALUE;
		Integer level_sum = 0;
		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {
				
				if (level_sum > max_sum) {
					max_sum = level_sum;
					level_sum = 0;
				}

				if (q.isEmpty()) {
					return max_sum;
				} else {
					q.add(null);
				}

			} else {

				level_sum = level_sum + node.val;

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
		}

		return max_sum;
	}

	public static void main(String[] args) {

		MaximumLevelSum ll = new MaximumLevelSum();
		System.out.println(ll.maxLevelSum(TreeGenerator.getTree()));
	}
}
