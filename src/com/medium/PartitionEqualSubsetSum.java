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
https://leetcode.com/problems/partition-equal-subset-sum/description/
-------------------------------------------------------

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

    Each of the array element will not exceed 100.
    The array size will not exceed 200.

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.


*
*/
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for( int num : nums ){
            sum += num;
        }
        if( sum%2 == 1 )return false;
        sum /= 2;
        boolean dp[][] = new boolean[nums.length][sum+1];
        for( int i=0 ; i<nums.length ; i++ ){
            dp[i][0] = true;
        }
        for( int i=1 ; i<sum+1 ; i++ ){
            for( int j=0 ; j<nums.length ; j++ ){
                    dp[j][i] = (((j-1)>=0 && dp[j-1][i] ) || ((i-nums[j])>=0 && (j-1)>=0 &&dp[j-1][i-nums[j]]) );
            }
        }
        return dp[nums.length-1][sum];
        
    }
}
