/**
 *		
 */
package com.medium;

import com.medium.BinaryTreeLevelOrderTraversal.TreeNode;

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
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
-------------------------------------------------------

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

*
*/
public class BinaryTreeMaximumPathSum {
    
    int answer = 0 ;
    
    public int maxPathSum(TreeNode root) {
        
        answer = Integer.MIN_VALUE;
        maxPathLength( root );
        return answer;
        
    }
    
    int maxPathLength( TreeNode root ){
        
        if( root == null ){
            return 0;
        }
        
        int maxLeft = maxPathLength( root.left );
        int maxRight = maxPathLength( root.right );  
        
        answer = Math.max( answer, root.val + maxLeft + maxRight );
        answer = Math.max( answer, root.val );
        answer = Math.max( answer, root.val + maxLeft );
        answer = Math.max( answer, root.val + maxRight );
        
        
        return Math.max( 0, Math.max( root.val + maxLeft , root.val + maxRight ) );
        
    } 
}
