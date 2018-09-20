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
https://leetcode.com/problems/set-matrix-zeroes/description/
-------------------------------------------------------

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?



*
*/
public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        if( m==0 )return;
        
        int n = matrix[0].length;
        
        boolean should0FirstCol = false;
        boolean should0FirstRow = false;
        
        for( int i=0; i<m ; i++ ){
            for( int j=0; j<n ; j++ ){
                if( matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    if( j==0 )
                        should0FirstCol = true;
                    if( i==0 )
                        should0FirstRow = true;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for( int i=1; i<m ; i++ ){
            for( int j=1 ; j<n ; j++ ){
                if( matrix[i][0] == 0 || matrix[0][j] == 0 )
                    matrix[i][j] = 0;
            }
        }
    
        if( should0FirstCol ){
            for( int j=0; j<m ; j++ ){
                matrix[j][0] = 0;   
            }
        }
        if( should0FirstRow ){
            for( int j=0; j<n ; j++ ){
                matrix[0][j] = 0;   
            }
        }
        
    }
}
