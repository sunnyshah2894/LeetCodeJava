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
https://leetcode.com/problems/product-of-array-except-self/description/
-------------------------------------------------------

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*
*/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int result[] = new int[nums.length];
        if(nums.length == 0)
            return result;
        
        result[ 0 ] = nums[0];
        
        for( int i=1 ; i<result.length ; i++ ){
            result[i] = result[i-1] * nums[i];
        }
        
        int currProd = 1;
        for( int i=nums.length-1 ; i>0 ; i-- ){
            result[i] = result[i-1] * currProd;
            currProd *= nums[i];
        }
        result[0] = currProd;
        
        return result;
    }
}
