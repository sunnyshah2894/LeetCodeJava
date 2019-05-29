/**
 *		
 */
package com.easy;

import java.util.HashSet;
import java.util.Set;

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
https://leetcode.com/problems/intersection-of-two-arrays/description/
-------------------------------------------------------

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.



*
*/
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for( int i: nums1 )nums1Set.add( i );
        for( int i: nums2 )if( nums1Set.contains(i) )intersection.add(i);
        
        int result[] = new int[intersection.size()];
        int index = 0 ;
        for( int i: intersection )result[index++] = i;
        return result;
        
    }
}
