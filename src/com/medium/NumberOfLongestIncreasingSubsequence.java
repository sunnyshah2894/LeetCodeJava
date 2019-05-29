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
https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
-------------------------------------------------------

Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:

Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:

Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int. 

*
*/
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        
        if( nums == null || nums.length == 0 )
            return 0;
        
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        
        int max_len = 0;
        
        for( int i=0 ; i<nums.length ; i++ ){
            dp[i] = 1;
            int prev = 0;
            int max = -1;
            for( int j=0 ; j<i ; j++ ){
                if( nums[j] < nums[i] ){
                    if( dp[j]+1 > dp[i] ){
                        prev = 0;
                        max = dp[j];
                    }
                    if( dp[j] == max )
                        prev += Math.max(1,count[j]);
                    dp[i] =  Math.max( dp[i], 1+dp[j] );
                }
            }
            count[i] = prev;
            max_len = Math.max( max_len , dp[i] );
        }
        
        int answer = 0 ;
        
        for( int i=0 ; i<nums.length ; i++ ){
            if( dp[i] == max_len ){
                answer += Math.max( 1, count[i] );
            }
        }
        
        return answer;
        
    }
}
