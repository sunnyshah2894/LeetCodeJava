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
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
-------------------------------------------------------

Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

 

Example 1:

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:



We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.

 

Note:

    The number of nodes in the tree will be between 1 and 500.
    The values of each node are unique.

*
*/
public class SmallestSubTreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = maxDepthOfTree( root );  
        System.out.println( maxDepth );
        return maxDepthSubTree( root,1,maxDepth );
    }
    public TreeNode maxDepthSubTree( TreeNode root, int depth, int maxDepth ){
        if( root == null ){
            return null;
        }
        if( depth == maxDepth ){
            return root;
        }
        if( root.left == null && root.right == null )
            return null;
        
        TreeNode leftSub = maxDepthSubTree( root.left, depth+1, maxDepth );
        TreeNode rightSub = maxDepthSubTree( root.right, depth+1, maxDepth );
        if( leftSub != null && rightSub != null )
            return root;
        else if( leftSub != null )
            return leftSub;
        else if( rightSub != null )
            return rightSub;
    
        else return null;
        
    }
    
    public int maxDepthOfTree( TreeNode root ){
        if( root == null )
            return 0 ;
        return Math.max( maxDepthOfTree( root.left ) , maxDepthOfTree( root.right ) ) + 1;
    }
    
}
