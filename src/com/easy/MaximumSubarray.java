/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/maximum-subarray/description/
-------------------------------------------------------

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*
*/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        
        if( nums.length == 0 ) return 0;
        
        int answer = nums[0], sum = nums[0];
        
        for( int i=1 ; i<nums.length ; i++ ){
            
            if( sum <= 0 )
                sum = 0 ;
            sum += nums[i];
            
            answer = Math.max( answer,sum );
            
        } 
        return answer;
        
    }
}
