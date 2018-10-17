/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
-------------------------------------------------------

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:

    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?

*
*/
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        
        if( nums.length == 0 )return false;
        int appendedNums[] = new int[nums.length*2];
        int startPoint = 0;
        appendedNums[0] = nums[0];
        appendedNums[nums.length] = nums[0];
        for( int i=1 ; i<nums.length ; i++ ){
            appendedNums[i] = nums[i] ; 
            appendedNums[nums.length+i] = nums[i];
            if( nums[i] < nums[i-1] )startPoint = i;
            
        }
        return ( Arrays.binarySearch( appendedNums,startPoint,startPoint+nums.length,target ) >= 0 );
        
    }
}
