/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
https://leetcode.com/problems/repeated-dna-sequences/description/
-------------------------------------------------------

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]


*
*/
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> temp = new HashSet<>();
        Set<String> done = new HashSet<>();
        
        for( int i=0 ; i<s.length()-10+1 ; i++ ){
            String sub = s.substring(i,i+10);
            if( !done.contains(sub) && temp.contains(sub) ){
                done.add(sub);
            }
            else temp.add(sub);
        }
        return new ArrayList<>(done);
    }
}
