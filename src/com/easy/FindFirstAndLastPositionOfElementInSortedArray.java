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
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
-------------------------------------------------------

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*
*/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        
        
        if( nums.length == 0 )return new int[]{-1,-1};
        
        int l=0, r=nums.length-1;
        while( l<r ){
            int mid = (l+r)/2;
            if( nums[mid] < target )
                l=mid+1;
            else r=mid;
        }
        if( nums[l] != target )return new int[]{-1,-1};
        
        int ar[] = new int[2];
        ar[0] = l;
        l=0 ; r=nums.length-1;
        while( l<r ){
            int mid = (l+r)/2;
            if( nums[mid] > target )
                r=mid;
            else l=mid+1;
        }
        if( l<nums.length && nums[l] > target )
            ar[1] = l-1 ;
        else if( l<nums.length && nums[l] == target )
            ar[1] = l;
        return ar;
        
    }
}
