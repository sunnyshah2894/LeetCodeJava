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
https://leetcode.com/problems/subsets/description/
-------------------------------------------------------

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]



*
*/
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        derivePowerSet( nums , visited , result, 0);
        return result;
    }
    
    void derivePowerSet( int[] nums, boolean visited[] , List<List<Integer>> powerSet , int index ){
        
        if( nums.length == 0 ){
            powerSet.add( new ArrayList<Integer>() );
            return;
        }
        visited[index] = true;
        if( index == nums.length - 1 ){
            List<Integer> ls1 = new ArrayList<>();
            for( int i=0 ; i<nums.length ; i++ ){
                if( visited[ i ] )
                    ls1.add( nums[i] );
            }
            powerSet.add( ls1 );
            
            visited[index] = false;
            List<Integer> ls2 = new ArrayList<>();
            for( int i=0 ; i<nums.length ; i++ ){
                if( visited[ i ] )
                    ls2.add( nums[i] );
            }
            powerSet.add( ls2 );
            return;
        }
        
        derivePowerSet( nums, visited, powerSet, index+1 );
        
        visited[index] = false;
        derivePowerSet( nums, visited, powerSet, index+1 );
        
    }
}
