/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.Map;
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
https://leetcode.com/problems/132-pattern/description/
-------------------------------------------------------

Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:

Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.

Example 2:

Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:

Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

*
*/
public class Pattern132 {
    public boolean find132patternBad(int[] nums) {
        
        if( nums.length < 3 )
            return false;
        
        int mini = nums[0];
        Map<Integer, Integer> mp = new HashMap<>();
        
        for( int i=1 ; i<nums.length ; i++ ){
            
            if( nums[ i ] < mini ){
                mini = nums[i];
            }
            else if( nums[ i ] > mini ){
                mp.put( nums[i],mini );
                for( int val : mp.keySet() ){
                    if( val > nums[i] && nums[i]>mp.get(val) ){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
    public boolean find132pattern(int[] nums) {
        
        if( nums.length < 3 )
            return false;
        
        int mini = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        
        for( int i=nums.length-1 ; i>=0 ; i-- ){
            
            if( nums[ i ] < mini ){
                return true;
            }
            while( !st.isEmpty() && nums[i] > st.peek() ) 
                mini = Math.max(mini,st.pop());
            
            st.push(nums[i]);
            
        }
        return false;
    }
}
