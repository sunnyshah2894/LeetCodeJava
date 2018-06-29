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
https://leetcode.com/problems/sum-of-left-leaves/description/
-------------------------------------------------------

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

*
*/
public class SumOfLeftLeaves {
	class TreeNode{
		int val;
		TreeNode left, right;
	}
	public int sumOfLeftLeaves(TreeNode root) {
        int val = 0 ; 
        return sumOfLeftLeaves(root, val , false);
    }
    public int sumOfLeftLeaves( TreeNode root, int val , boolean isLeft ){
        if( root == null )return val;
        
        if( root.left == null && root.right == null && isLeft ) return val+root.val;
        
        if( root.left != null ){ 
            val = sumOfLeftLeaves(root.left, val , true);
        }
        if( root.right != null ){
            val = sumOfLeftLeaves(root.right, val , false);
        }
        return val;
    }
}
