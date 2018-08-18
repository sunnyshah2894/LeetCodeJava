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
	https://github.com/sunnyshah28
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/score-of-parentheses/description/
-------------------------------------------------------

Given a balanced parentheses string S, compute the score of the string based on the following rule:

    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

 

Example 1:

Input: "()"
Output: 1

Example 2:

Input: "(())"
Output: 2

Example 3:

Input: "()()"
Output: 2

Example 4:

Input: "(()(()))"
Output: 6

 

Note:

    S is a balanced parentheses string, containing only ( and ).
    2 <= S.length <= 50



*
*/
public class ScoreOfParenthesis {
    public int scoreOfParentheses(String S) {
        
        Stack<Integer> st = new Stack<>();
        char ch[] = S.toCharArray();
        
        int answer = 0;
        
        for( char c : ch ){
            
            if( c == '(' ){
                st.push((int)c);
            }
            else{
                int temp = 0;
                if( st.peek() == (int)'(' ){
                    st.pop();
                    st.push(1);
                }
                else{
                    while( st.peek() != (int)'(' ){
                        temp += (int)(st.pop())*2;
                    }
                    st.pop();
                    st.push(temp);
                }
            }
            
        }
        
        for( int i : st ){
            answer += i;
        }
        return answer;
    }
}
