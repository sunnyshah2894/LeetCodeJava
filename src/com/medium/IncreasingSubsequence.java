/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
https://leetcode.com/problems/increasing-subsequences/description/
-------------------------------------------------------

Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:

Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

Note:

    The length of the given array will not exceed 15.
    The range of integer in the given array is [-100,100].
    The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.


*
*/
public class IncreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> curr = new ArrayList<>();
        Set<String> hst = new HashSet<>();
        
        for( int i=0 ; i<nums.length ; i++ ){
            generateSubs( i,nums,curr,result,hst );
        }
        return result;
    }
    
    void generateSubs( int index, int[] nums, List<Integer> curr, List<List<Integer>> result, Set<String> hst ){
        if( index >= nums.length )
            return;
        curr.add( nums[index] );
        
        String ar = Arrays.toString(curr.toArray());
        if( !hst.contains(ar) && curr.size() > 1 ){
            hst.add( (ar) );
            result.add( new ArrayList<Integer>(curr) );
        }
        
        for( int i=index+1 ; i<nums.length ; i++ ){
            if(nums[i]>=nums[index]){
                generateSubs( i,nums,curr,result,hst );
            }
        }
        curr.remove( curr.size()-1 );
        
    }
    
}
