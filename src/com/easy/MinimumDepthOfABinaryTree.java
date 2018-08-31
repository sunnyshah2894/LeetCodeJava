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
https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
-------------------------------------------------------

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.



*
*/
public class MinimumDepthOfABinaryTree {
	
	class TreeNode{
		int val;
		TreeNode right, left;
		
	}
	
	int minD ;
    public int minDepth(TreeNode root) {
        if( root == null )return 0;
        minD = Integer.MAX_VALUE;
        minDepth( root, 1 );
        return minD;
    }
    
    void minDepth( TreeNode root, int depth ){
        if( root == null ) return;
        if( root.left == null && root.right == null ){
            minD = Math.min(minD, depth);
            return;
        }
        if( depth > minD ) return;
        else{
            minDepth( root.left , depth+1 );
            minDepth( root.right , depth+1 );
        }
    }
    
}
