package com.algorithms.trees.traversals.levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.practise.leetcode.TreeNode;

// Queue and delimeter approach
// Basically if null acts a delimeter at the end of each level
// If we incur a null and q is empty that means end of tree
public class LevelOrderTraversal {

	List<List<Integer>> result = new ArrayList<>();
	List<Integer> local = new ArrayList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null) {
			queue.add(root);
			queue.add(null);
		}

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node == null) {
				result.add(local);
				local = new ArrayList<>();
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}

			else {
				local.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return result;
	}
}