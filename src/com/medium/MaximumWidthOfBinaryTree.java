/**
 *		
 */
package com.medium;

import java.util.LinkedList;
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
https://leetcode.com/problems/maximum-width-of-binary-tree/description/
-------------------------------------------------------

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer. 

*
*/
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int answer = 1;
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        
        node.offer( root );
        index.offer( 0 );
        
        while( !node.isEmpty() ){
            
            int times = node.size()-1;
            int initialIndex = index.poll();
            TreeNode initialNode = node.poll();
            
            if( initialNode.left != null ){
                node.offer( initialNode.left );
                index.offer( 2*initialIndex );
            }
            if( initialNode.right != null ){
                node.offer( initialNode.right );
                index.offer( 2*initialIndex + 1 );
            }
            
            while( times-->0 ){
                
                TreeNode curr = node.poll();
                int pos = index.poll();
                answer = Math.max( answer, pos - initialIndex + 1 );
                
                if( curr.left != null ){
                    node.offer( curr.left );
                    index.offer( 2*pos );
                }
                if( curr.right != null ){
                    node.offer( curr.right );
                    index.offer( 2*pos+1 );
                }
                
            }
            
        }
        
        return answer;
        
    }
}
