/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
-------------------------------------------------------

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


*
*/
public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Map = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for( int i: nums1 ){
            int currCount = nums1Map.getOrDefault( i , 0 );
            nums1Map.put( i , currCount+1 );
        }
        for( int i: nums2 ){
            int count = nums1Map.getOrDefault( i , 0 );
            if( count>0 ){
                nums1Map.put( i , count-1 );
                intersection.add( i );
            }
        }
        int result[] = new int[intersection.size()];
        int index = 0 ;
        for( int i: intersection ){
            result[index++] = i;
        }
        return result;
    }
}
