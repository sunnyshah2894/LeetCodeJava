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
https://leetcode.com/problems/maximal-rectangle/description/
-------------------------------------------------------

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

*
*/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        
        int answer = 0;
        if( matrix.length == 0 )return 0;
        
        int curr_heights[] = new int[matrix[0].length];
        
        for( int i=0 ; i<matrix.length ; i++ ){
            for( int j=0 ; j<matrix[0].length ; j++ ){
                
                if( matrix[i][j] == '0' )
                    curr_heights[ j ] = 0;
                else 
                    curr_heights[ j ] = 1 + curr_heights[ j ];
                
            }
            answer = Math.max( answer, largestRectangleArea( curr_heights ) );
        }
        
        return answer;
        
        
    }
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
