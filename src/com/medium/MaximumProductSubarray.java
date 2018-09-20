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
https://leetcode.com/problems/maximum-product-subarray/description/
-------------------------------------------------------

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*
*/
public class MaximumProductSubarray {
	int maxProduct(int num[]) {
        
        int n = num.length;
        int answer = num[0];
        int max = num[0], min = num[0];
        
        for( int i=1 ; i<n; i++ ){
            
            if (num[i] < 0){
                int t=max; max=min; min=t;
            }                
            
            max = Math.max(num[i], max * num[i]);
            min = Math.min(num[i], min * num[i]);

            answer = Math.max(answer, max);
        }
        return answer;
    }
}
