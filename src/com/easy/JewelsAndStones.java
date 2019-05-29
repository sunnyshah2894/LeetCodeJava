/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/jewels-and-stones/description/
-------------------------------------------------------

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:

Input: J = "z", S = "ZZ"
Output: 0

Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.



*
*/
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int j = J.length();
        int s = S.length();
        
        Set<Character> jewels = new HashSet<>();
        
        char chJ[] = J.toCharArray();
        char chS[] = S.toCharArray();
        for( int i=0 ; i<j ; i++ ){
            jewels.add(chJ[i]);
        }
        
        int ans = 0 ;
        for( int i=0 ; i<s ; i++ ){
            if( jewels.contains(chS[i])){
                ans++;
            }
        }
        return ans;
    }

}
