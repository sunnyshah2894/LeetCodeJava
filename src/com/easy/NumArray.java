/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/range-sum-query-immutable/description/
-------------------------------------------------------

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.


*
*/
class NumArray {
    
    long sum[];
    public NumArray(int[] nums) {
        
        sum = new long[nums.length+1];
        sum[0] = 0;
        for( int i=1 ; i<=nums.length ; i++ ){
            sum[i] = sum[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return (int)(sum[j+1] - sum[i]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
