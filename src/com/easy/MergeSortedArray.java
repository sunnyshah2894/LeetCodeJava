/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/merge-sorted-array/description/
-------------------------------------------------------

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]



*
*/
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        for( int i=0 ; i<nums2.length; i++ )
            nums1[i+m] = nums2[i];
        Arrays.sort(nums1,0,m+n);
    }
}
