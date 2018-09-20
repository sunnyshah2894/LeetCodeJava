/**
 *		
 */
package com.easy;

import com.easy.NaryTreeLevelOrderTraversal.Node;

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
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
-------------------------------------------------------

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:
 

 

We should return its max depth, which is 3.

Note:

    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.


*
*/
public class MaxDepthOfNaryTree {	
    public int maxDepth(Node root) {
        return maxDepth( root,1 );
    }
    int maxDepth( Node root,int level ){
        if( root == null )return 0;
        int depth = level;
        for( Node child : root.children ){
            depth = Math.max( depth,maxDepth( child,level+1 ) );
        }
        return depth;
    }
}
