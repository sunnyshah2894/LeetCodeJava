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
https://leetcode.com/problems/longest-increasing-subsequence/description/
-------------------------------------------------------

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?


*
*/
public class LongestIncreasingSubsequence {
	/*
	 * O(n^2) approach
	 */
	public int lengthOfLIS_ON2(int[] nums) {
        
        if(nums.length == 0 )return 0;
        
        int answer = 0 ;
        int dp[] = new int[nums.length];
        
        dp[0] = 1 ;
       
        for( int i=1 ; i<nums.length ; i++ ){ 
            dp[i] = 1; 
            for( int j=i-1; j>-1 ; j-- ){
                if( dp[i] <= dp[j] && nums[j] < nums[i] ){
                    dp[i] = dp[j]+1;
                }
            }
            if( dp[i] == 0 )dp[i]=1;
        }
        
        for( int i=0 ; i<nums.length ; i++ )
            answer = Math.max(answer, dp[i]);
        
        return answer;
        
    }
	/*
	 * Based on: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	 * 
	 * 
		Our strategy determined by the following conditions,
		
		1. If A[i] is smallest among all end 
		   candidates of active lists, we will start 
		   new active list of length 1.
		
		2. If A[i] is largest among all end candidates of 
		  active lists, we will clone the largest active 
		  list, and extend it by A[i].
		
		
		3. If A[i] is in between, we will find a list with 
		  largest end element that is smaller than A[i]. 
		  Clone and extend this list by A[i]. We will discard all
		  other lists of same length as that of this modified list.
  
	 * But instead of maintaining list of all valid subsequence, we will just maintain a single list of subsequence. 
	 * Add a number to the end of the list if the number is bigger than any number in the list. 
	 * Add a number in the midway - This will allow us our list to be prepared in case the longest subsequence has not still been encountered.
	 * 
	 * 
	 * O(NLogN) solution
	 */
	public int lengthOfLISONlogN(int[] nums) {
        
        if(nums.length == 0 )return 0;
        
        int size = 1 ;
        int result[] = new int[nums.length];
        result[0] = nums[0];
        for( int num: nums ){
            int pos = lowerBound( result, size , num );
            if( pos == size ){ 
                result[size++] = num;
            }
            else result[pos] = num;
        }
        
        return size;
        
    }
    /*
	 * -If searched element doesn't exist function returns index of first element which is bigger than searched value.
	 * 
	 * -If searched element is bigger than any array element function returns first index after last
	 * element.
	 * 
	 * -If searched element is lower than any array element function returns index of first element.
	 * 
	 * -If there are many values equals searched value function returns first occurrence.
	 */
	public static int lowerBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
}
