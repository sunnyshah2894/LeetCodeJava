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
https://leetcode.com/problems/diameter-of-binary-tree/description/
-------------------------------------------------------

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. 


*
*/
public class DiameterOfBinaryTree {
	int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        computeDiameter(root);
        return diameter;
    }
    public int computeDiameter(TreeNode root){
        if( root == null ) return 0;
        
        int left = computeDiameter( root.left );
        int right = computeDiameter( root.right );
        
        diameter = Math.max( left+right , diameter );
        return Math.max(left,right)+1;
        
    }
}
