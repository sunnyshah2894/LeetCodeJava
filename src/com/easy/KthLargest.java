/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
-------------------------------------------------------

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8

Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.


*
*/
public class KthLargest {
	PriorityQueue<Integer> myHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        myHeap = new PriorityQueue<>();
        this.k = k;
        
        for( int num: nums ){
            myHeap.add( num );
        }
        
        if( myHeap.size() > k ){
            int polls = myHeap.size() - k;
            while( polls-->0 )
                myHeap.poll();
        }
        
    }
    
    public int add(int val) {
        myHeap.offer(val);
        if( myHeap.size() > k )
            myHeap.poll();
        return myHeap.peek();
    }
}
