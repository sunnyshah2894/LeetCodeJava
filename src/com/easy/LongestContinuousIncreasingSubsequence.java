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
https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
-------------------------------------------------------

Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:

Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 

Example 2:

Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 

Note: Length of the array will not exceed 10,000. 

*
*/
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        
        int answer = 0 ;
        int curr_val = Integer.MIN_VALUE;
        int curr_max = 0;
        
        for( int i=0 ; i<nums.length ; i++ ){
            
            if( curr_val >= nums[i] ){
                answer = Math.max( answer, curr_max );
                curr_max = 0;
             
            }
            curr_max++;
            curr_val = nums[i];
                
        }
        answer = Math.max( answer,curr_max );
        return answer;
        
    }
}
