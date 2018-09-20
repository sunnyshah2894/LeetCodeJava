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
https://leetcode.com/problems/third-maximum-number/description/
-------------------------------------------------------

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.



*
*/
public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
        
        long max1 , max2, max3 ;
        max1=max2=max3=Long.MIN_VALUE;
        
        boolean foundMax1, foundMax2, foundMax3;
        foundMax1 = foundMax2 = foundMax3 = false;
        
        for( int num: nums ){
            if( num > max1 ){
                max1 = num;
                foundMax1 = true;
            }
        }
        if( foundMax1 ){
            for( int num: nums ){
                if( num > max2 && num < max1 ){
                    max2 = num;
                    foundMax2 = true;
                }
            }
        }
        if( foundMax2 ){
            for( int num: nums ){
                if( num > max3 && num < max2 ){
                    max3 = num;
                    foundMax3 = true;
                }
            }
        }
        
        if( foundMax3 )return (int)max3;
        else if( foundMax1 ) return (int)max1;
        else return -1;
        
        
    }
}
