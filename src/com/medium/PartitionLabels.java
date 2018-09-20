/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/partition-labels/description/
-------------------------------------------------------

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.

*
*/
public class PartitionLabels {
	    public List<Integer> partitionLabels(String S) {
	        int minIndex[] = new int[26] ;
	        int maxIndex[] = new int[26] ;
	        char ch[] = S.toCharArray() ;
	        List<Integer> l = new ArrayList<>();
	        for( int i=0 ; i<26 ; i++ ){
	            minIndex[i] = 501;
	            maxIndex[i] = -1;
	        }
	        
	        for( int i=0; i<S.length(); i++ ){
	            if( minIndex[ch[i]-'a'] > i ){
	                minIndex[ch[i]-'a'] = i;
	            }
	            if( maxIndex[ch[i]-'a'] < i ){
	                maxIndex[ch[i]-'a'] = i;
	            }
	        }
	        
	        int count = 0 ;
	        for( int i=0 ; i<S.length() ; i++ ){
	            count++;
	            int currIndex = i;
	            int indexToReachTill = maxIndex[ch[i]-'a'] ;
	            for( ; i < indexToReachTill; i++ ){
	                indexToReachTill = Math.max( indexToReachTill , maxIndex[ch[i]-'a'] ) ;
	            }
	            l.add( i - currIndex + 1 );
	        }
	        return l;
	        
	    }

}
