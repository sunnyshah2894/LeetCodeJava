/**
 *		
 */
package com.medium;

import java.util.Stack;

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
https://leetcode.com/problems/next-greater-element-ii/description/
-------------------------------------------------------

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.

Note: The length of given array won't exceed 10000. 

*
*/
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int answer[] = new int[nums.length];
        
        for( int i=0 ; i<n ; i++ )
            answer[i] = -1;
        
        Stack<Integer> st = new Stack<>();
        for( int i=0 ; i<2*n ; i++ ){
            int curr = nums[i%n];
            while( !st.isEmpty() && nums[st.peek()] < curr ){
                answer[ st.peek() ] = curr;
                st.pop();
            }
            if( i<n ){
                st.push(i);
            }
        }
        return answer;
    }
}
