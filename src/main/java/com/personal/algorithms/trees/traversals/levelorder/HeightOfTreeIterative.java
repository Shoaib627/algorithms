package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class HeightOfTreeIterative {

	
	public int height(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int height = 1;
		while(!q.isEmpty()) {
			
			TreeNode node = q.poll();
			
			if(node == null) {
				
				if(q.isEmpty()) {
					return height;
				}
				
				else {
					height++;
					q.add(null);
				}	
			}
			else {
				if(node.left !=null) {
					q.add(node.left);
				}
				
				if(node.right !=null) {
					q.add(node.right);
				}
			}
		}	
		return height;
	}
	
	public static void main(String[] args) {

		HeightOfTreeIterative s = new HeightOfTreeIterative();
		System.out.println(s.height(TreeGenerator.getTree()));

	}
}
