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
https://leetcode.com/problems/implement-strstr/description/
-------------------------------------------------------

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


*
*/
public class StrStrInJava {
	public int strStr(String haystack, String needle) {
        return KMP( haystack , needle );
    }
    
    int KMP(String test, String pattern) {
		
        int k=0;
        int pi[] = new int[ pattern.length() ];
        int patLen = pattern.length();
        int testLen = test.length();
        
        char patCh[] = pattern.toCharArray();
        char testCh[] = test.toCharArray();
        if( patLen == 0 )return 0;
        
        constructPiTable( patCh , pi );
        
		for( int i=0 ; i<testLen ; i++ ){
            
			while( k>0 && testCh[i] != patCh[k] )		
				k = pi[ k-1 ];                                     
			if( testCh[i] == patCh[k] )
				k++;
			if( k == patLen ){
				return (i-patLen+1);
			}
		}
		return -1;
		
    }
    
    void constructPiTable( char[] pattern , int[] pi ) {
			
		pi[0]=0;
		int k=0;
        int patLen = pattern.length;
        
		for( int i=1 ; i<patLen ; i++ ){
			
			while( k>0 && pattern[i] != pattern[k] )	
				k=pi[k-1];
			
			if( pattern[k] == pattern[i] )     
				k=k+1;
            
			pi[i]=k;
		}
		
    }
}
