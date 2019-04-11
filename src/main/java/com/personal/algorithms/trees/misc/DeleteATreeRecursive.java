package com.personal.algorithms.trees.misc;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;

public class DeleteATreeRecursive {

	public static void main(String[] args) {

		TreeNode node = TreeGenerator.getTree();

		node = null;

		System.out.println(node);

	}
}
