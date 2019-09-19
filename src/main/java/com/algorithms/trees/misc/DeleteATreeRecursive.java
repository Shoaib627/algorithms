package com.algorithms.trees.misc;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class DeleteATreeRecursive {

	public static void main(String[] args) {

		TreeNode node = TreeGenerator.getTree();

		node = null;

		System.out.println(node);

	}
}
