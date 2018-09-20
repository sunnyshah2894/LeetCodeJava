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
https://leetcode.com/problems/degree-of-an-array/description/
-------------------------------------------------------

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:

Input: [1,2,2,3,1,4,2]
Output: 6

Note:
nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

*
*/
public class DegreeOfAnArray {
	public int findShortestSubArray(int[] nums) {
        
        int numsMinIndex[] = new int[500005];
        int numsFreq[] = new int[500005];
        boolean visited[] = new boolean[500005];
        
        int maxFreq = 0 ;
        int ans = 500001 ;
        
        for( int i=0; i<nums.length ; i++){
            if( !visited[nums[i]] ){
                numsMinIndex[nums[i]] = i;
                visited[nums[i]] = true;       
            }
        }
        for( int i=0 ; i< nums.length ; i++ ){
            numsFreq[nums[i]]++;
            
            if( maxFreq < numsFreq[nums[i]] ){
                maxFreq = numsFreq[nums[i]];
                ans = (i - numsMinIndex[nums[i]] + 1);
            }
            else if( maxFreq == numsFreq[nums[i]] ){
                ans = Math.min(ans, (i - numsMinIndex[nums[i]] + 1) );
            }
        }
        
        return ans;
        
    }
}
