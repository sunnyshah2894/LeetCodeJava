/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/subarray-sum-equals-k/description/
-------------------------------------------------------

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Note:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


*
*/
public class SubArraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        if( n==0 ) return 0;
        else if( n==1 ) return (nums[0] == k)?1:0;
        
        int sum = 0;
        
        Map<Integer,Integer> counter = new HashMap<>();
        counter.put( 0,1 );
        
        int answer = 0 ;
        for( int i=0; i<n ; i++ ){
            sum = sum+nums[i];
            answer += counter.getOrDefault( sum-k,0 );
            counter.put( sum , counter.getOrDefault( sum,0 ) + 1 );
        }
        return answer;
        
    }
}
