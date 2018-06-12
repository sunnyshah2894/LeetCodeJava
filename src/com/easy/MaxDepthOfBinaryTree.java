/**
 *		
 */
package com.easy;

/**
 *
Author: 
	Sunny Shah 
	sunnyshah452@gmail.com 
	https://github.com/sunnyshah28
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
-------------------------------------------------------
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.

 
 
 * 
 */
public class MaxDepthOfBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * 
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return findMaxDepth(root, 0);
	}

	public int findMaxDepth(TreeNode root, int depthTillNow) {
		if (root == null)
			return depthTillNow;

		int depthLeft = findMaxDepth(root.left, depthTillNow + 1);
		int depthRight = findMaxDepth(root.right, depthTillNow + 1);

		return Math.max(depthLeft, depthRight);

	}

}
