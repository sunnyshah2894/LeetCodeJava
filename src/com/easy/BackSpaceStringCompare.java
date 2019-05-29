/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/backspace-string-compare/description/
-------------------------------------------------------

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

Follow up:

    Can you solve it in O(N) time and O(1) space?



*
*/
public class BackSpaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
        Stack<Character> sS = new Stack<>();
        Stack<Character> sT = new Stack<>();
        
        char sch[] = S.toCharArray();
        char tch[] = T.toCharArray();
        
        for( char ch: sch ){
            if( ch == '#' ){
                if( !sS.isEmpty() )
                    sS.pop();
            }
            else{
                sS.push(ch);
            }
        }
        for( char ch: tch ){
            if( ch == '#' ){
                if( !sT.isEmpty() ){
                    sT.pop();
                }
            }
            else{
                sT.push(ch);
            }
        }
        
        if( !sS.isEmpty() && !sT.isEmpty() ){
            while( !sS.isEmpty() && !sT.isEmpty() ){
                if( sS.pop() != sT.pop() )
                    return false;
            }
            if( !sS.isEmpty() || !sT.isEmpty() )
                return false;
            else return true;
        }
        else if( sS.isEmpty() && sT.isEmpty() ){
            return true;
        }
        
        return false;
        
        
    }
}
