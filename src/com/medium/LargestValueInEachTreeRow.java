/**
 *		
 */
package com.medium;

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

-------------------------------------------------------

*
*/
public class LargestValueInEachTreeRow {
	
	class TreeNode{
		int val;
		TreeNode left,right;
	}
	
	public List<Integer> largestValuesIterative( TreeNode root ){
		List<Integer> result = new ArrayList<>();
        if( root == null ) return result;
       
        Queue<TreeNode> qs = new LinkedList<>();
        
        qs.add( root );
        
        while( !qs.isEmpty() ){
            
            int times = qs.size();
            int max = Integer.MIN_VALUE;
            while(times-->0){
                TreeNode curr = qs.poll();
                max = Math.max(curr.val,max);
                if( curr.left != null )
                    qs.add( curr.left  );
                if( curr.right != null )
                    qs.add( curr.right );
            }
            result.add(max);
        }
        
        return result;
	}
	
	public List<Integer> largestValuesRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if( root == null ) return result;
        
        else result.add( Integer.MIN_VALUE );
        findLargest( root,result,0 );
        return result;
    }
    
    void findLargest( TreeNode root, List<Integer> result, int depth ){
        
        if( root == null )return;
        
        if( depth>=result.size() ){
            result.add( Integer.MIN_VALUE );
        }
        result.set( depth , Math.max( result.get(depth),root.val ) );
        findLargest( root.left, result, depth+1 );
        findLargest( root.right, result, depth+1 );
        
    }
}
