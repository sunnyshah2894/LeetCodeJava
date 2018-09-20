/**
 *		
 */
package com.medium;

import java.util.HashSet;
import java.util.Set;

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
https://leetcode.com/problems/remove-k-digits/description/
-------------------------------------------------------

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:

    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


*
*/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        
        char ch[] = num.toCharArray();
        Set<Integer> hs = new HashSet<>();
        int start = -1;
        char result[] = new char[num.length()-k];
        
        for( int j=start+1 ; j<num.length() ; j++ ){
            if( j==num.length()-k ){
                for( int i=j ; i<j+k ; i++ ){
                    hs.add( i );
                    start = i;
                }
                k=0;
                j = start+1;
            }      
            else{
                int temp = k;
                int next = j+1;
                int nextMinIndex = j;
                char minVal = ch[j];
                while( temp-->0 ){                   
                    if( ch[next] < minVal ){
                        minVal = ch[next];
                        nextMinIndex = next;
                    }
                    next++;
                }
                if( nextMinIndex > j ){
                    for( int i=j ; i<nextMinIndex ; i++ ){
                        hs.add( i );
                        start = i;
                    }
                    k -= (nextMinIndex-j);
                    j = start+1;
                }
                
            }
        }

        int index = 0 ;
        for( int i=0 ; i<num.length() ; i++ ){
            if( !hs.contains( i ) )
                result[index++] = ch[i];
        }
        
        if( result.length == 0 )
            return new String("0");
        
        int startIndex = 0;
        while( startIndex<index && result[startIndex] == '0' ){
            startIndex++;
        }
        if( index-startIndex == 0 ){
            return new String("0");
        }
        
        return new String( result,startIndex, index-startIndex );
    }
}
