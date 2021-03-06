/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/reordered-power-of-2/description/
-------------------------------------------------------

Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

Example 1:

Input: 1
Output: true

Example 2:

Input: 10
Output: false

Example 3:

Input: 16
Output: true

Example 4:

Input: 24
Output: false

Example 5:

Input: 46
Output: true

*
*/
public class ReorderedPowerof2 {
    public boolean reorderedPowerOf2(int N) {
        String number = "" + N;
        int countNumberDigits[] = new int[10];
        for( char ch : number.toCharArray() ){
            countNumberDigits[ch-'0']++;
        }
        boolean answer = false;
        
        for( int j=0 ; j<32 ; j++ ){
            
            int power = (1<<j);
            String powerString = "" + power ;
            if( powerString.length() > number.length() ){
                return answer ; 
            }
            else if( powerString.length() == number.length() ){
                int countFreq[] = new int[10];
                for( char ch : powerString.toCharArray() ){
                    countFreq[ch-'0']++;
                }
                boolean flag = true;
                for( int i=0 ; i<10 ; i++ ){
                    if( countNumberDigits[i] != countFreq[i] ){
                        flag = false;
                        break;
                    }
                }
                if( flag )
                    return true;
            }
            
        }
        return answer;
    }
}
