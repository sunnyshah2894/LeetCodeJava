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
https://leetcode.com/problems/single-number-ii/description/
-------------------------------------------------------

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3

Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99


*
*/
public class SingleNumberII {
	public int singleNumber(int[] nums) {
        int val1 = 0;
        int val2 = 0;
        for( int num: nums ){
            val1 = val1^num & (~val2);
            val2 = val2^num & (~val1);
        }
        return val1;
    }
}
