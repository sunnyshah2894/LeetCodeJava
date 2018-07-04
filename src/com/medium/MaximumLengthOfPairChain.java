/**
 *		
 */
package com.medium;

import java.util.Arrays;
import java.util.Comparator;

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
https://leetcode.com/problems/maximum-length-of-pair-chain/description/
-------------------------------------------------------

You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:

Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]

Note:

    The number of given pairs will be in the range [1, 1000].


*
*/
public class MaximumLengthOfPairChain {
	public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] int1, int[] int2) {
                return (int1[1] - int2[1]);
            }
        });
        int answer = 0 ;
        int currEnd = Integer.MIN_VALUE;
        for( int[] i : pairs ){
            if( i[0] > currEnd ){
                currEnd=i[1];
                answer++;
            }
        }
        
        return answer;
    }
}
