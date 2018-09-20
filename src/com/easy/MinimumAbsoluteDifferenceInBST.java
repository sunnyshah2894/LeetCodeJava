/**
 *		
 */
package com.easy;

import com.easy.BalancedBinaryTree.TreeNode;

/**
 *
Author: 
	Sunny Shah 
	sunnyshah452@gmail.com 
	https://github.com/sunnyshah2894
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
-------------------------------------------------------

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

Note: There are at least two nodes in this BST. 


*
*/
public class MinimumAbsoluteDifferenceInBST {
	TreeNode prev = null ; 
    int minValue = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        minValue = Integer.MAX_VALUE;
        prev = null;
        return getMinimumAbsoluteDifference(root);  
    }
    public int getMinimumAbsoluteDifference( TreeNode root ){
        if( root == null ){
            return minValue;
        }
        getMinimumAbsoluteDifference( root.left );
        if( prev != null ){
            minValue = Math.min( root.val - prev.val , minValue ) ; 
        }
        prev = root;
        getMinimumAbsoluteDifference( root.right );
        return minValue;
    }
}
