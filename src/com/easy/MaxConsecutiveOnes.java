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
https://leetcode.com/problems/max-consecutive-ones/description/
-------------------------------------------------------

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000


*
*/
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        int currMax = 0 ;
        int answer = 0;
        for( int num : nums ){
            
            if( num == 1 ){
                currMax++;
            }
            else currMax = 0;
            answer = Math.max( currMax,answer );
            
        }
        
        return answer;
    }
}
