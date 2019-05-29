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
https://leetcode.com/problems/longest-valid-parentheses/description/
-------------------------------------------------------

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

*
*/
public class LongestValidParenthesis {
    public int longestValidParentheses(String A) {
        
        char ch[] = A.toCharArray();
        Stack<Integer> st = new Stack<>();
        int answer = 0;
        for( int i=0 ; i<ch.length ; i++ ){
           
            if( ch[i] == ')' ){
                
                int sum = 0 ;
                while( !st.isEmpty() ){
                    
                    if( st.peek() == 1 ){
                        sum += 2;
                        st.pop();
                        st.push(sum);
                        break;
                    }
                    else if( st.peek() == -1 ){
                        break;
                    }
                    else if( st.peek() > 1 ){
                        sum += st.pop();
                    }
                    answer = Math.max( sum,answer );
                    
                }
                
            }
            else{
                st.push(1);
            }
            
        }
        int sum = 0;
        while( !st.isEmpty() ){
            if( st.peek() == 1 || st.peek() == -1 ){
                answer = Math.max( answer,sum );
                st.pop();
                sum = 0;
            }
            else{
                sum += st.pop();
            }
        }
        answer = Math.max( answer,sum );
        
        return answer;
        
    }
}
