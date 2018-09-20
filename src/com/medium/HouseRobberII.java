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
https://leetcode.com/problems/house-robber-ii/description/
-------------------------------------------------------

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

*
*/
public class HouseRobberII {
    public int rob(int[] nums) {
        
        if( nums.length == 0 ) return 0;
        if( nums.length == 1 ) return nums[0];
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for( int i=1 ; i<nums.length-1 ; i++ ){
            dp[i+1] = Math.max( dp[i-1]+nums[i], dp[i] );
        }
        int answer = dp[nums.length-1];
        dp[nums.length] = 0;
        dp[nums.length-1] = nums[nums.length-1];
        for( int i=nums.length-2 ; i>0 ; i-- ){
            dp[i] = Math.max( dp[i+2]+nums[i], dp[i+1] );
        }
        answer = Math.max(answer,dp[1]);
        
        return answer;
        
    }
}
