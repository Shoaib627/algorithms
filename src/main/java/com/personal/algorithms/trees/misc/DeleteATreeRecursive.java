package com.personal.algorithms.trees.misc;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class DeleteATreeRecursive {

	public static void main(String[] args) {

		TreeNode node = TreeGenerator.getTree();

		node = null;

		System.out.println(node);

	}
}
