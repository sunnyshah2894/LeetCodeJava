/**
 *		
 */
package com.hard;

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
https://leetcode.com/problems/first-missing-positive/description/
-------------------------------------------------------

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Note:

Your algorithm should run in O(n) time and uses constant extra space.

*
*/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        
        if( nums.length == 0 )return 1;
        int n = nums.length+1;
        for( int i=0 ; i<nums.length ; i++ )
            if( nums[i] <= 0 )
                nums[i] = n;
        
        for( int i=0 ; i<nums.length ; i++ ){
            int index = Math.abs( nums[i] ) - 1;
            if( index < nums.length && nums[index] > 0 )
                nums[index] *= -1;
        }
        
        for( int i=0 ; i<nums.length ; i++ )
            if( nums[i] > 0 )
                return (i+1);
        
        return n;
        
    }
}
