/**
 *		
 */
package com.easy;

import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/majority-element/description/
-------------------------------------------------------

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2


*
*/
public class MajorityElement {
	public int majorityElement(int[] nums) {
        int count = nums.length/2 ;
        Map<Integer,Integer> counter = new HashMap<>();
        
        for( int num: nums ){
            
            int currCount = counter.getOrDefault( num,0 );
            counter.put( num,currCount+1 );
            
            if( (currCount+1) > count )return num;
            
        }
        return -1; 
    }
}
