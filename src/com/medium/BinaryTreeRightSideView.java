/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
https://leetcode.com/problems/binary-tree-right-side-view/description/
-------------------------------------------------------

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

*
*/
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if( root == null )
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root );
        
        while( !queue.isEmpty() ){
            
            int times = queue.size() ;
            int val = -1;
            while( times-->0 ){
                TreeNode curr = queue.poll();
                val = curr.val;
                if( curr.left != null )
                    queue.offer( curr.left );
                if( curr.right != null )
                    queue.offer( curr.right );
            }
            result.add( val );
        }
        
        return result;
        
    }
}
