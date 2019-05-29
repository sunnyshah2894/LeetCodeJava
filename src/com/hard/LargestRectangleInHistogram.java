/**
 *		
 */
package com.hard;

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
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
-------------------------------------------------------

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10

*
*/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> ht = new Stack<>();
        Stack<Integer> it = new Stack<>();
        
        int answer = 0;
        for( int i=0 ; i<heights.length ; i++ ){
            
            if( ht.isEmpty() || ht.peek() <= heights[i] ){
                ht.push( heights[i] );
                it.push( i );
            }
            else{
                
                while( !ht.isEmpty() && ht.peek() > heights[i] ){
                    int curr_ht = ht.pop();
                    if( ht.isEmpty() )
                        answer = Math.max( answer, curr_ht*(i) );
                    else
                        answer = Math.max( answer, curr_ht*(i-it.peek()-1) );
                }
                ht.push(heights[i]);
                it.push( i );
                
            }
            
        }
        while( !ht.isEmpty() ){
            int curr_ht = ht.pop();
            if( ht.isEmpty() )
                answer = Math.max( answer, curr_ht*(heights.length) );
            else
                answer = Math.max( answer, curr_ht*(heights.length-it.peek()-1) );
        }
        
        return answer;
        
    }
}
