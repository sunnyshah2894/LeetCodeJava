/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
-------------------------------------------------------

Given an n-ary tree, return the preorder traversal of its nodes' values.
 

For example, given a 3-ary tree:
			1
	   	  /	| \
		 3	2  4
	    / \
	   5   6	

Return its preorder traversal as: [1,3,5,6,2,4].
 

Note: Recursive solution is trivial, could you do it iteratively?

*
*/
public class NaryPrePostOrderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<>();
        solvePre(root,ls);
        return ls;
    }
    
    void solvePre( Node root,List<Integer> ls ){
        if( root == null ) return;
        ls.add( root.val );
        for( Node n : root.children ){
            solvePre( n,ls );
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ls = new ArrayList<>();
        solvePost(root,ls);
        return ls;
    }
    
    void solvePost( Node root,List<Integer> ls ){
        if( root == null ) return;
        for( Node n : root.children ){
            solvePost( n,ls );
        }
        ls.add( root.val );
    }
}
