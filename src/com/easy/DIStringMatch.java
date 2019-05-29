/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/di-string-match/description/
-------------------------------------------------------

Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]

 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]

Example 2:

Input: "III"
Output: [0,1,2,3]

Example 3:

Input: "DDI"
Output: [3,2,0,1]

 

Note:

    1 <= S.length <= 10000
    S only contains characters "I" or "D".

*
*/
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        
        int countOfI = 0;
        int result[] = new int[S.length()+1];
        
        int d_index = S.length();
        int i_index = 0;
        
        for( int i=0 ; i<S.length() ; i++ ){
            
            char ch = S.charAt(i);
            if( ch == 'I' ){
                countOfI++;
                result[i] = i_index++;
            }
            else{
                result[i] = d_index--;
            }
            
        }
        result[S.length()] = countOfI;
        
        return result;
        
    }
}
