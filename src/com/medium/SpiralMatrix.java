/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/spiral-matrix/description/
-------------------------------------------------------

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


*
*/
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int rows = matrix.length;
        if( rows == 0 ) return ls;
        int cols = matrix[0].length;
        int numOfElements = rows*cols;
        
        for( int i=0 ; i<rows ; i++ ){
            for( int j=i ; j<cols-i && numOfElements>0 ; j++ ){
                numOfElements--;
                ls.add( matrix[i][j] );
            }
            for( int j=i+1 ; j<rows-i && numOfElements>0 ; j++ ){
                numOfElements--;
                ls.add( matrix[j][cols-i-1] );
            }
            for( int j=cols-2-i ; j>=i && numOfElements>0 ; j-- ){
                numOfElements--;
                ls.add( matrix[rows-1-i][j] );
            }
            for( int j=rows-2-i ; j>i && numOfElements>0 ; j-- ){
                numOfElements--;
                ls.add( matrix[j][i] );
            }
        }
        return ls;
    }
}
