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
https://leetcode.com/problems/jump-game/description/
-------------------------------------------------------

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.



*
*/
public class JumpGame {
    public boolean canJump(int[] nums) {
        
        int posToReach = nums.length-1;
        for( int currPos = posToReach-1 ; currPos>=0 ; currPos-- ){
            while( currPos>=0 && currPos + nums[currPos] < posToReach ){
                currPos--;
            }
            posToReach = currPos;
        }
        return (posToReach==0);
    }
}
