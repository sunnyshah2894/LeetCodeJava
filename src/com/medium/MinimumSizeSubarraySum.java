/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/minimum-size-subarray-sum/description/
-------------------------------------------------------

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

*
*/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        
        int left = 0 ; 
        int right = 0 ;
        int minAns = nums.length+1;
        int sum = 0;
        while( left<=right && right <= nums.length ){
            
            if( left == nums.length ) 
                break;
            
            if( sum >= s ){
                minAns = Math.min( minAns,right-left );
                sum -= nums[left];
                left++; 
            }
            else{
                if( right == nums.length )
                    break;
                sum += nums[right];
                right++;
                
            }
            
        }
        if( sum >= s ){
            minAns = Math.min( minAns,right-left+1 );
        }
        
        if( minAns == nums.length + 1 )
            return 0;
        return minAns ;
        
    }
}
