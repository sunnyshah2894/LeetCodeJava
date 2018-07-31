/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/score-after-flipping-matrix/description/
-------------------------------------------------------

We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.

 

Example 1:

Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

 

Note:

    1 <= A.length <= 20
    1 <= A[0].length <= 20
    A[i][j] is 0 or 1.



*
*/
public class ScoreAfterFlippingMatrix {
	public int matrixScore(int[][] A) {
        
        for( int i=0 ; i<A.length ; i++ ){
            if( A[i][0] == 0 ){
                for( int j=0 ; j<A[0].length ; j++ ){
                    A[i][j] = ( A[i][j] + 1 )%2;
                }
            }
        }
        
        for( int i=0 ; i<A[0].length ; i++ ){
            int total = 0 ;
            for( int j=0 ; j<A.length ; j++ ){
                    total += A[j][i] ;
            }
            if( total <= (int)(A.length/2) ){
                for( int j=0 ; j<A.length ; j++ ){
                    A[j][i] = ( A[j][i] + 1 )%2;
                }
            }
        }
        int answer = 0;
        for( int i=0 ; i<A.length ; i++ ){
            for( int j=A[0].length-1 ; j >= 0 ; j-- ){
                answer += ( A[i][j]<<( A[0].length - 1 - j ) ) ;
            }
        }
        
        return answer;
    }
}
