/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
-------------------------------------------------------

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:
 

 

We should return its level order traversal:

 

 

[
     [1],
     [3,2,4],
     [5,6]
]

 

Note:

    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.


*
*/
public class NaryTreeLevelOrderTraversal {
	class Node{
		int val;
		List<Node> children;
	}
	public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ls = new ArrayList<>();
        if( root==null ) return ls;
        
        Queue<Node> qs = new LinkedList<>();
        
        qs.add( root );
        int level = 0;
        while( !qs.isEmpty() ){
            
            int times = qs.size();
            ls.add( new ArrayList<Integer>() );
            List<Integer> tempList = ls.get( level++ );
            while( times-->0 ){
                Node temp = qs.poll();
                tempList.add( temp.val );
                for( Node n : temp.children ){
                    qs.add( n );
                }
            }
            
        }
        return ls;
    }
}
