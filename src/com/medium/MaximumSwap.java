/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/maximum-swap/description/
-------------------------------------------------------

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: 9973
Output: 9973
Explanation: No swap.

Note:

    The given number is in the range [0, 108]


*
*/
public class MaximumSwap {
	
    public int maximumSwap(int num) {
        char ch[] = Integer.toString(num).toCharArray();
        for( int i=0 ; i<ch.length ; i++ ){
            
            char min = ch[i] ;
            char max = ch[i] ;
            int maxIndex = i ;
            for( int j=i ; j<ch.length ; j++ ){
                if( max <= ch[j] && ch[j] > min ){
                    
                    max = ch[j];
                    maxIndex = j;
                }
            }
            if( maxIndex != i ){
                char t = ch[i];
                ch[i] = ch[maxIndex];
                ch[maxIndex] = t;
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }

}
