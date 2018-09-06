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
https://leetcode.com/problems/balanced-binary-tree/description/
-------------------------------------------------------

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:
    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

Return false.

*
*/
public class BalancedBinaryTree {

	/**
	 * 
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	      public int val;
	      public TreeNode left;
	      public TreeNode right;
	      public TreeNode(int x) { val = x; }
	  }
	 
	
	    public boolean isBalanced(TreeNode root) {
	        result = true;
	        findMaxDepth(root, 0);
	        return result;
	    }
	    static boolean result = true;
	   
	    public int findMaxDepth(TreeNode root, int depthTillNow) {
			if (root == null)
				return depthTillNow;

			int depthLeft = findMaxDepth(root.left, depthTillNow + 1);
			int depthRight = findMaxDepth(root.right, depthTillNow + 1);
	        
	        if( Math.abs(depthRight-depthLeft) > 1 )result = false;
	        
			return Math.max(depthLeft, depthRight);

		}
	
}
