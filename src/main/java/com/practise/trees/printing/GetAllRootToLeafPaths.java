package com.practise.trees.printing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.practise.leetcode.TreeNode;




/**
 * 
 *  
 *  The algorithm traverses the tree in pre-order manner and uses an array list to store the paths.
When a leaf node is reached, the path is printed.
path - an array list that stores the current path.

Step 1: Add root data to the array list. 
Step 2: If root is a leaf, print the path and return.
Step 3: Recursively traverse the left subtree.
Step 4: Recursively traverse the right subtree.

Note: A new array list is created in the recursive calls (Steps 3 and 4) because we do not want to share the same array list in left and right subtree calls as the paths will be different.
We add nodes up to the current path to the array list because the paths up to the current node are common for left and right subtrees.
 *
 */


public class GetAllRootToLeafPaths {
	

	public List<List<Integer>> printRootToLeafPaths(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<>();
		printRootToLeafPaths(root, path, result);
		return result;
	}

	private void printRootToLeafPaths(TreeNode root, ArrayList<Integer> path, List<List<Integer>> result) {

		if (root == null) {
			return;
		}
		path.add(root.val);

		if (root.left == null && root.right == null) {
			result.add(path);
			return;
		}

		printRootToLeafPaths(root.left, new ArrayList<Integer>(path), result);
		printRootToLeafPaths(root.right, new ArrayList<Integer>(path), result);
	}



	public static void main(String[] args) {
		GetAllRootToLeafPaths g = new GetAllRootToLeafPaths();
		
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		
		
		
		System.out.println(g.printRootToLeafPaths(root));
	}
	
	
	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int level = 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node == null) {
				if (q.isEmpty()) {
					return level;
				}

				else {
					level++;
					q.add(null);
				}

			}

			else {

				if (node.left == null && node.right == null) {
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

		return level;

	}

}
