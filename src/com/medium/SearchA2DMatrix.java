/**
 *		
 */
package com.medium;

import java.util.Arrays;

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
https://leetcode.com/problems/search-a-2d-matrix/description/
-------------------------------------------------------

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false



*
*/
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix.length == 0 || matrix[0].length == 0 ) return false;
        int lb = lowerBound(matrix, target);
        if( lb<matrix.length && matrix[lb][0] == target )return true;
        else lb--;
        
        return (lb>=0 && Arrays.binarySearch( matrix[lb] , target ) >= 0);
        
    }
    public static int lowerBound(int[][] array, int value) {
		int low = 0;
		int high = array.length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid][0]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
