/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/positions-of-large-groups/description/
-------------------------------------------------------

In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.

Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.

Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]

Note:  1 <= S.length <= 1000

*
*/
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ls = new ArrayList<>();
        
        char ch[] = S.toCharArray();
        int currChar = 'A';
        int start = -1;
        
        for( int i=0 ; i<ch.length ; i++ ){
            if( ch[i] != currChar ){
                if( start != -1 && i-start>=3 ){
                    List<Integer> temp = new ArrayList<>();
                    temp.add( start );
                    temp.add( i-1 );
                    ls.add(temp);
                }
                currChar = ch[i];
                start = i;
            }
        }
        if( start != -1 && ch.length-start>=3 ){
            List<Integer> temp = new ArrayList<>();
            temp.add( start );
            temp.add( ch.length-1 );
            ls.add(temp);
        }
        return ls;
        
    }
}
