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
https://leetcode.com/problems/repeated-string-match/description/
-------------------------------------------------------

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000. 

*
*/
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
        
        int lenB = B.length();
        
        StringBuilder sbA = new StringBuilder(A);
        
        char chB[] = B.toCharArray();
        
        int pi[] = new int[ B.length() ];
        constructPiTable( chB , pi );
        
        int answer = 1;
        while( sbA.length() < lenB ){
            answer++ ;
            sbA.append(A);
        }
        
        if( KMP( sbA.toString(),B,pi ) != -1 )return answer;
        if( KMP( sbA.append(A).toString() , B , pi ) != -1  )return answer+1;
        
        return -1;
    
    }
    
    int KMP(String test, String pattern, int pi[] ) {
		
        int k=0;
        
        int patLen = pattern.length();
        int testLen = test.length();
        
        char patCh[] = pattern.toCharArray();
        char testCh[] = test.toCharArray();
        if( patLen == 0 )return 0;
        
        
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
