/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
https://leetcode.com/problems/minimum-genetic-mutation/description/
-------------------------------------------------------

A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

    Starting point is assumed to be valid, so it might not be included in the bank.
    If multiple mutations are needed, all mutations during in the sequence must be valid.
    You may assume start and end string is not the same.

 

Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1

 

Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2

 

Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3

*
*/
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Map<String,Integer> hs = new HashMap<>();
        Set<String> hst = new HashSet<>();
        int result = minMutation( start,end,bank,hs,hst );
        if( result == Integer.MAX_VALUE )
            return -1;
        return result;
    }
    
    public int minMutation(String start, String end, String[] bank, Map<String,Integer> hs, Set<String> hst) {
        
        if( start.equals( end ) ){
            return 0;
        }
        hst.add( start );
        int minReq = Integer.MAX_VALUE;
        for( int i=0 ; i<bank.length ; i++ ){
            String gene = bank[i];
            if( !hst.contains(gene) && isMutation(start,gene) ){
                minReq = Math.min( minMutation( gene,end,bank,hs,hst ),minReq );
            }
        }
        hst.remove(start);
        if( !(minReq == Integer.MAX_VALUE) ){
            return minReq+1;
        }
        
        return Integer.MAX_VALUE;
    }
    
    public boolean isMutation( String src, String dst ){
        char sch[] = src.toCharArray();
        char dch[] = dst.toCharArray();
        int dist = 0 ;
        for( int i=0 ; i<8 ; i++ ){
            if( sch[i] != dch[i] )
                dist++;
        }
        return (dist==1);
    }
    
}
