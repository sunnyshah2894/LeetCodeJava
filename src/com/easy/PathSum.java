/**
 *		
 */
package com.easy;

/**
 *
 * Author: Sunny Shah 
		sunnyshah452@gmail.com 
		https://github.com/sunnyshah28
		https://leetcode.com/sunnyshah28 
		https://www.linkedin.com/in/sunnyshah28
 *
 *
 * -------------------------------------------------------
 * https://leetcode.com/problems/path-sum/description/
 * -------------------------------------------------------
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 
 
 
 * 
 */
public class PathSum {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public boolean hasPathSum(TreeNode root, int sum) {

			if (root == null)
				return false;
			if (root.left == null && root.right == null && sum - root.val == 0)
				return true;
			boolean result = hasPathSum(root.left, sum - root.val);
			return (result || hasPathSum(root.right, sum - root.val));

		}
	}
}
