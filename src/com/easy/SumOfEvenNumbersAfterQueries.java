/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/
-------------------------------------------------------

We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.

 

Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

*
*/
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        
        int sum = 0 ;
        for( int i : A ){
            if( i%2 == 0 )
                sum += i;
        }
        
        int answer[] = new int[queries.length];
        
        for( int i=0 ; i<queries.length ; i++ ){
            
            int val = queries[i][0];
            int index = queries[i][1];
            
            int old_val = A[index];
            int new_val = A[index] + val;
            
            if( old_val % 2 == 0 && new_val % 2 == 0 ){
                sum = sum - old_val + new_val;
            }
            else if( old_val % 2 != 0 && new_val % 2 == 0 ){
                sum = sum + new_val;
            }
            else if( old_val % 2 == 0 && new_val % 2 != 0 ){
                sum -= old_val;
            }
            A[index] = new_val;
            
            answer[i] = sum;
            
        }
        return answer;
    }
}
