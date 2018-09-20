/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/4sum-ii/description/
-------------------------------------------------------

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0



*
*/
public class FourSumCount {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        Map<Integer,Integer> sumAB = new HashMap<>();
        
        for( int i : A ){
            for( int j : B ){
                int count = sumAB.getOrDefault( (i+j) , 0 );
                sumAB.put((i+j) , count+1);
            } 
        }
        int answer = 0 ;
        for( int i : C ){
            for( int j : D ){
                int count = sumAB.getOrDefault( -1*(i+j) , 0 );
                answer += count;
            } 
        }
        
        return answer;
        
    }
}
