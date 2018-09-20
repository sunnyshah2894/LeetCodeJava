/**
 *		
 */
package com.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

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
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
-------------------------------------------------------
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

*
*/
public class KthLargestInAnArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);
            
            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }
	
	public int findKthLargestUsingSorting(int[] nums, int k){
		Arrays.sort(nums);
		return nums[ nums.length - k ];
	}
}
