/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
-------------------------------------------------------

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


*
*/
public class BinaryTreeLevelOrderTraversal {
	class TreeNode{
		/**
		 * @param i
		 */
		public TreeNode(int i) {
			val = i;
		}
		int val;
		TreeNode left, right;
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
        maxDepth = -1;
        List<List<Integer>> result = new ArrayList<>();
        generateZigZagOrder(root, 0, result);
        return result;
    }
    int maxDepth = -1;
    
    void generateZigZagOrder( TreeNode root , int depth , List<List<Integer>> result ){
        if(root == null)
            return ;
        
        if( depth > maxDepth ){
            maxDepth = depth;
            result.add( new ArrayList<Integer>() );
        }
        
        result.get(depth).add( root.val );
        
        generateZigZagOrder(root.left,depth+1,result);
        generateZigZagOrder(root.right,depth+1,result);
        
    }
}
