/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
https://leetcode.com/problems/most-frequent-subtree-sum/description/
-------------------------------------------------------

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3

return [2, -3, 4], since all the values happen only once, return all of them in any order.

Examples 2
Input:

  5
 /  \
2   -5

return [2], since 2 happens twice, however -5 only occur once.

Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer. 


*
*/
public class MostFrequentSubsetSum {
	
	class TreeNode{
		int val;
		TreeNode left,right;
	}
	
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> sums = new ArrayList<Integer>();
        findSum(root,sums);
        
        if( sums.size() == 0 ) return new int[0];
        
        
        Map<Integer,Integer> freq = new HashMap<>();
        for( int i=0 ; i<sums.size() ; i++ ){
            freq.put( sums.get(i) , freq.getOrDefault( sums.get(i),0 ) + 1 );
        }
        
        int maxFreq = 0;
        int mostFreq = Integer.MIN_VALUE;
        int countMaxFreq = 0;
        for( int s : freq.keySet() ){
            if( freq.get(s) > maxFreq ){
                maxFreq = freq.get(s);
                mostFreq = s;
            }
        }
        
        for( int s : freq.keySet() ){
            if( maxFreq == freq.get(s) )
                countMaxFreq++;
        }
        
        int result[] = new int[countMaxFreq];
        int index=0;
        Set<Integer> st = new HashSet<>(sums);
        for( int i : st ){
            if( freq.get( i ) == maxFreq )
                result[index++] = i;
        }
        return result;
        
    }
    
    int findSum( TreeNode root,List<Integer> sums ){
        
        
        if( root == null ){
            return 0;
        }
        
        
        if( root.left == null && root.right == null ){
            sums.add( root.val );
            return root.val;
        }
        
        int sum1 = findSum( root.left,sums );
        int sum2 = findSum( root.right,sums );
    
        sums.add( sum2+sum1+root.val );
        return (sum2+sum1+root.val);
    }
    
}
