/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;


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
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
-------------------------------------------------------

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]


*
*/
public class BottomUpBinaryLevelOrderTraversal {
	class TreeNode{
		int val;
		TreeNode right,left;
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        maxDepth = -1;
        List<List<Integer>> result = new ArrayList<>();
        generateLevelOrder(root, 0, result);
        return result;
    }
   
    int maxDepth = -1;
    
    void generateLevelOrder( TreeNode root , int depth , List<List<Integer>> result ){
        if(root == null)
            return ;
        
        if( depth > maxDepth ){
            maxDepth = depth;
            result.add( 0, new ArrayList<Integer>() );
        }
        
        result.get(maxDepth - depth).add( root.val );
        
        generateLevelOrder(root.left,depth+1,result);
        generateLevelOrder(root.right,depth+1,result);
        
    }
}
