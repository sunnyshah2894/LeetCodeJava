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
https://leetcode.com/problems/increasing-triplet-subsequence/description/
-------------------------------------------------------

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false. 

Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.



*
*/
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3 )return false;
        
        int min1 = Integer.MAX_VALUE - 1;
        int min2 = Integer.MAX_VALUE;
        for( int num: nums ){
            if( num <= min1 ){
                min1=num ;   
            }
            else if( num <= min2 ){
                min2=num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
