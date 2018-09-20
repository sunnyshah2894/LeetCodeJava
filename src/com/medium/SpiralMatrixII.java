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
https://leetcode.com/problems/spiral-matrix-ii/description/
-------------------------------------------------------

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


*
*/
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int rows = n;
        int cols = n;
        int matrix[][] = new int[n][n];
        int numOfElements = rows*cols;
        int index = 1 ;
        
        for( int i=0 ; i<rows ; i++ ){
            for( int j=i ; j<cols-i && numOfElements>0 ; j++ ){
                numOfElements--;
                matrix[i][j] = index++;
            }
            for( int j=i+1 ; j<rows-i && numOfElements>0 ; j++ ){
                numOfElements--;
                matrix[j][cols-i-1] = index++;
            }
            for( int j=cols-2-i ; j>=i && numOfElements>0 ; j-- ){
                numOfElements--;
                matrix[rows-1-i][j] = index++;
            }
            for( int j=rows-2-i ; j>i && numOfElements>0 ; j-- ){
                numOfElements--;
                matrix[j][i] = index++;
            }
        }
        return matrix;
    }
}
