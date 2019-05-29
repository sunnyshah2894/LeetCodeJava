/**
 *		
 */
package com.easy;

import java.util.Arrays;

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
https://leetcode.com/problems/maximum-product-of-three-numbers/description/
-------------------------------------------------------

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6

Example 2:

Input: [1,2,3,4]
Output: 24

Note:

    The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
    Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

*
*/
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        Arrays.sort( nums );
        
        max = Math.max( nums[0]*nums[1]*nums[nums.length-1],max );
        max = Math.max( nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1],max );
        
        return max;
        
    }
}
