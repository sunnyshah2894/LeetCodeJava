/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Author: 	Sunny Shah 
 * 			sunnyshah452@gmail.com 
 * 			https://github.com/sunnyshah2894
 * 			https://leetcode.com/sunnyshah28 
 * 			https://www.linkedin.com/in/sunnyshah28
 *
 *
 * -------------------------------------------------------
 * https://leetcode.com/problems/path-sum-ii/description/
 * ------------------------------------------------------- 
 
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 
 
 * 
 * 
 */
public class PathSumII {
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

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		l.clear();
		currList.clear();
		hasPathSum(root, sum);
		return l;
	}

	static List<List<Integer>> l = new ArrayList<>();
	static List<Integer> currList = new ArrayList<>();

	public void hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return;
		currList.add(root.val);
		if (root.left == null && root.right == null && sum - root.val == 0){
			//add to list 
			l.add(new ArrayList<>(currList));
		}

		hasPathSum(root.left, sum - root.val);
		hasPathSum(root.right, sum - root.val);
		currList.remove(currList.size() - 1);

	}
}
