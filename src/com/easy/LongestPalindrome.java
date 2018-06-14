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
https://leetcode.com/problems/longest-palindrome/description/
-------------------------------------------------------

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


*
*/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        char ch[] = s.toCharArray();
        int countOfEachAlphabet[] = new int[100];
        int ans = 0 ;
        for( char c: ch ){
            countOfEachAlphabet[c-'A']++ ;
        }
        boolean isSingleAlphaRemaining = false;
        for( int i=0 ; i<100 ; i++ ){
            if( countOfEachAlphabet[i]==1 ){
                isSingleAlphaRemaining = true;                
            }
            else if( countOfEachAlphabet[i] > 1 ){
                ans += (countOfEachAlphabet[i]/2)*2;
                if( countOfEachAlphabet[i]%2 == 1 )
                    isSingleAlphaRemaining = true;
            }
        }
        if(isSingleAlphaRemaining)
            ans++;
        return ans;
    }
}
