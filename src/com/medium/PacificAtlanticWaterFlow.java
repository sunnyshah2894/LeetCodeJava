/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
https://leetcode.com/problems/pacific-atlantic-water-flow/description/
-------------------------------------------------------

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

    The order of returned grid coordinates does not matter.
    Both m and n are less than 150.

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).


*
*/
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
        List<int[]> result = new ArrayList<>();
        if( matrix.length == 0 )return result;
        boolean dpTouchPacific[][] = new boolean[matrix.length][matrix[0].length];
        boolean dpTouchAtlantic[][] = new boolean[matrix.length][matrix[0].length];
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        
        for( int i=0 ; i<visited.length ; i++ ){
            Arrays.fill( visited[i],false );
        }
        
        
        for( int i=0 ; i<matrix.length ; i++ ){
            checkConnToPacific( i,0,dpTouchPacific,visited,matrix );                
        }
        for( int i=0 ; i<matrix[0].length ; i++ ){ 
            checkConnToPacific( 0,i,dpTouchPacific,visited,matrix );                
        }
        
        
        for( int i=0 ; i<visited.length ; i++ ){
            Arrays.fill( visited[i],false );
        }
        
        
        for( int i=0 ; i<matrix.length ; i++ ){
            checkConnToAtlantic( i,matrix[0].length-1,dpTouchAtlantic,visited,matrix );                
        }
        for( int i=0 ; i<matrix[0].length ; i++ ){
            checkConnToAtlantic( matrix.length-1,i,dpTouchAtlantic,visited,matrix );                
        }
        
        for( int i=0 ; i<matrix.length ; i++ ){
            for( int j=0 ; j<matrix[0].length ; j++ ){
                if( dpTouchAtlantic[i][j] && dpTouchPacific[i][j] )
                    result.add( new int[]{i,j} );
            }
        }
        return result;
        
    }
    boolean checkConnToPacific( int i, int j, boolean [][]dpTouchPacific , boolean visited[][] , int matrix[][] ){
        
        if( i>=dpTouchPacific.length || i<0 || j<0 || j>=dpTouchPacific[0].length )
            return false;        
        if( visited[i][j] ){
            return dpTouchPacific[i][j];
        }
        
        visited[i][j] = true;
        dpTouchPacific[i][j] = true;
            
        if( i-1>=0 && matrix[i-1][j]>=matrix[i][j] )
            checkConnToPacific(i-1,j,dpTouchPacific,visited,matrix ); 
    
        if( j-1>=0 && matrix[i][j-1]>=matrix[i][j] )
            checkConnToPacific(i,j-1,dpTouchPacific,visited,matrix ) ; 
        
        if( i+1<matrix.length && matrix[i+1][j]>=matrix[i][j] ) 
            checkConnToPacific(i+1,j,dpTouchPacific,visited,matrix ) ;
        
        if( j+1<matrix[0].length && matrix[i][j+1]>=matrix[i][j] )
            checkConnToPacific(i,j+1,dpTouchPacific,visited,matrix ) ;
          
       return true;
            
    }
    
    boolean checkConnToAtlantic( int i, int j, boolean [][]dpTouchAtlantic , boolean visited[][], int matrix[][] ){
        
        if( i>=dpTouchAtlantic.length || i<0 || j<0 || j>=dpTouchAtlantic[0].length )
            return false;
        if( visited[i][j] ){
            return dpTouchAtlantic[i][j];
        }
        
        visited[i][j] = true;
        dpTouchAtlantic[i][j] = true;
            
        if( i-1>=0 && matrix[i-1][j]>=matrix[i][j] )
            checkConnToAtlantic(i-1,j,dpTouchAtlantic,visited,matrix ); 
    
        if( j-1>=0 && matrix[i][j-1]>=matrix[i][j] )
            checkConnToAtlantic(i,j-1,dpTouchAtlantic,visited,matrix ) ; 
        
        if( i+1<matrix.length && matrix[i+1][j]>=matrix[i][j] ) 
            checkConnToAtlantic(i+1,j,dpTouchAtlantic,visited,matrix ) ;
        
        if( j+1<matrix[0].length && matrix[i][j+1]>=matrix[i][j] )
            checkConnToAtlantic(i,j+1,dpTouchAtlantic,visited,matrix ) ;
          
       return true;
            
    }
}
