/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/target-sum/description/
-------------------------------------------------------

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.


*
*/
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        //int currSigns[] = new int[nums.length];
        //Arrays.fill( currSigns,1 ); 
        int maxSum = 0 ; 
        for( int num: nums )maxSum+=num;
        
        if( maxSum < S || ( (S+maxSum)%2 == 1 ) ) return 0;
        
        int dp[] = new int[ (S+maxSum)/2 + 1 ];
        dp[0] = 1;
        for( int num : nums ){
            for( int i=(S+maxSum)/2 ; i>=num ; i-- ){
                dp[i] += dp[i-num];
            }
        }
        
        return dp[ (S+maxSum)/2 ];
        //return noOfWays( nums,S,0,currSigns );
    }
    public int noOfWays( int[] nums, int S , int index , int curr[] ){
        
        if( index >= nums.length )return 0;
        else if( index == nums.length-1 ){
            int sum = 0, count = 0; 
            for( int i=0 ; i<nums.length-1 ; i++ ){
                sum += nums[i] * curr[i];
            }
            if( sum + nums[index] == S )count++;
            if( sum - nums[index] == S )count++;
            return count;
        }
        else{
            int count = 0 ;
            curr[index] = 1;
            count += noOfWays( nums,S,index+1,curr );
            curr[index] = -1;
            count += noOfWays( nums,S,index+1,curr );
            return count;
        }
        
    }
}
