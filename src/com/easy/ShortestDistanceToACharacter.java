/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/shortest-distance-to-a-character/description/
-------------------------------------------------------

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

 

Note:

    S string length is in [1, 10000].
    C is a single character, and guaranteed to be in string S.
    All letters in S and C are lowercase.



*
*/
public class ShortestDistanceToACharacter {
	public int[] shortestToChar(String S, char C) {
        char ch[] = S.toCharArray();
        int answer[] = new int[ch.length];
        
        int cPos[] = new int[ch.length];
        int index=0;
        for( int i=0 ; i<ch.length ; i++ ){
            if( ch[i] == C )
                cPos[index++] = i;
        }
        
        for( int i=0 ; i<ch.length ; i++ ){
            int t = lowerBound( cPos,index,i );
            if( t > 0 )
                answer[i] = Math.min( Math.abs( cPos[t]-i ) , Math.abs( cPos[t-1] - i ) );
            else 
                answer[i] = Math.abs( cPos[t]-i );
        }
        return answer; 
        
    }
    /*
	 * -If searched element doesn't exist function returns index of first
	 * element which is bigger than searched value.<br> -If searched element is
	 * bigger than any array element function returns first index after last
	 * element.<br> -If searched element is lower than any array element
	 * function returns index of first element.<br> -If there are many values
	 * equals searched value function returns first occurrence.<br>
	 */
	public static int lowerBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
