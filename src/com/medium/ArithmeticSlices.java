/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/arithmetic-slices/description/
-------------------------------------------------------

A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic.

1, 1, 2, 5, 7


A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.


*
*/
public class ArithmeticSlices {
	
	public int numberOfArithmeticSlicesOptimized(int[] A) {
		
		int dp=0;
		int answer=0;
		
		for( int i=2 ; i<A.length ; i++ ){
			if( A[i]-A[i-1] == A[i-1]-A[i-2] ){
				dp++;
				answer += dp;
			}
			else{
				dp=0;
			}
		}
		return answer;
		
	}
	
	public int numberOfArithmeticSlices(int[] A) {
        
        int dp[] = new int[Math.max(A.length+1,3)];
        boolean newAP = true;
        for( int i=2 ; i<A.length ; i++ ){
            if( !newAP ){
                if( A[i]-A[i-1] == A[i-1]-A[i-2] ){
                    dp[i+1] = dp[i] + 1 + dp[i] - dp[i-1];
                }
            }
            else{
                if( A[i]-A[i-1] == A[i-1]-A[i-2] ){
                    dp[i+1] = dp[i] + 1;
                }
                newAP = false;
            }
            if( dp[i+1] == 0 )newAP = true;
        }
        
        int answer = 0;
        int currVal = dp[1];
        
        for( int i=1 ; i<A.length ; i++ ){
            if( dp[i+1] == 0 ){
                answer += currVal;
            }
            currVal = dp[i+1];
        }
        answer += currVal;
        return answer;
    }
}
