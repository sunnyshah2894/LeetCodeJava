/**
 *		
 */
package com.medium;

import java.util.Stack;

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
https://leetcode.com/problems/sum-of-subarray-minimums/description/
-------------------------------------------------------

Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.

 

Note:

    1 <= A.length <= 30000
    1 <= A[i] <= 30000

*
*/
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        
        int left[] = new int[A.length] ;
        int right[] = new int[A.length] ; 
        Stack<Integer> st = new Stack<>();
        Stack<Integer> stindex = new Stack<>();
        
        for( int i=0 ; i<A.length ; i++ ){
            if( st.isEmpty() ){
                left[i] = i;
                st.push(A[i]);
                stindex.push(i);
            }
            else{
                int index = i;
                while( !st.isEmpty() && A[i] < st.peek() ){
                    st.pop();
                    index = stindex.pop();
                }
                left[i] = index;
                st.push( A[i] );
                stindex.push( left[i] );
            }
        }
        st.clear();
        stindex.clear();
        for( int i=A.length-1 ; i>=0 ; i-- ){
            if( st.isEmpty() ){
                right[i] = i;
                st.push(A[i]);
                stindex.push(i);
            }
            else{
                int index = i;
                while( !st.isEmpty() && A[i] <= st.peek() ){
                    st.pop();
                    index = stindex.pop();
                }
                right[i] = index;
                st.push( A[i] );
                stindex.push( right[i] );
            }
        }
        
        long mod = 1000000007;
        long ans = 0;
        for( int i=0 ; i<left.length ; i++ ){
            ans += ((( (i-(long)left[i]+1) * ( (long)right[i] - i + 1 ) ) % mod ) * A[i] ) % mod;
            ans %= mod;
        }
        
        return (int)ans;
        
        
    }
}
