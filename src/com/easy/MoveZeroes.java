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
https://leetcode.com/problems/move-zeroes/description/
-------------------------------------------------------

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

*
*/
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        
        int currAvailablePos = 0;
        for( int i=0 ; i<nums.length ; i++ ){
            if( nums[i] != 0 ){
                int temp = nums[i];    
                nums[i] = 0;
                nums[currAvailablePos++] = temp;
            }
        }
      
    }
}
