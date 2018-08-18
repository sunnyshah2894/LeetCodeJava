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
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
-------------------------------------------------------

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]


*
*/
public class BinaryTreeZigzagOrderTraversal {
	
	class TreeNode{
		int val;
		TreeNode right, left;
	}
	
	int maxDepth = -1;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        maxDepth = -1;
        List<List<Integer>> result = new ArrayList<>();
        generateZigZagOrder(root, 0, result);
        return result;
    }
    void generateZigZagOrder( TreeNode root , int depth , List<List<Integer>> result ){
        if(root == null)
            return ;
        
        if( depth > maxDepth ){
            maxDepth = depth;
            result.add( new ArrayList<Integer>() );
        }
        
        if( depth%2 == 1 ){
            result.get(depth).add( 0, root.val );
        }
        else{
            result.get(depth).add( root.val );
        }
        generateZigZagOrder(root.left,depth+1,result);
        generateZigZagOrder(root.right,depth+1,result);
        
    }
    
}
