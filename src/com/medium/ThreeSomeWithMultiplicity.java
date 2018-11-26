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
https://leetcode.com/problems/3sum-with-multiplicity/description/
-------------------------------------------------------

Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.

 

Example 1:

Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (A[i], A[j], A[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Example 2:

Input: A = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.

 

Note:

    3 <= A.length <= 3000
    0 <= A[i] <= 100
    0 <= target <= 300

*
*/
public class ThreeSomeWithMultiplicity {
    public int threeSumMulti(int[] A, int target) {
        
        int counts[][] = new int[105][3005];
        
        for( int i=0 ; i<A.length ; i++ ){
            for( int j=0 ; j<101 ; j++ ){
                if( i==0 )
                    counts[j][i] = 0;
                else
                    counts[j][i] = counts[j][i-1];
            }
            counts[A[i]][i]++;
        }
        
        long answer = 0;
        long mod = 1000000007;
        
        for( int i=0 ; i<A.length ; i++ ){
            for( int j=i+1 ; j<A.length ; j++ ){
                
                int req = target-(A[i]+A[j]);
                
                if( req>=0 && req<=100 ){
                    answer += ( ((1* 1) % mod ) * (counts[req][A.length-1] - counts[req][j]) ) % mod;
                    answer = answer % mod;
                } 
            }
        }
        
        return (int)answer;
        
    }
}
