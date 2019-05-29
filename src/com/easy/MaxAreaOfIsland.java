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
https://leetcode.com/problems/max-area-of-island/description/
-------------------------------------------------------

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]

Given the above grid, return 0.



*
*/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if( grid.length == 0 )return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int answer = 0 ;
        for( int i=0 ; i<grid.length ; i++ ){
            for( int j=0 ; j<grid[0].length ; j++ ){
                if( !visited[i][j] && grid[i][j]==1 )
                    answer = Math.max( answer , maxAreaOfIsland(grid,i,j,visited) );
            }
        }
        return answer;
    }
    
    int maxAreaOfIsland(int[][] grid, int i, int j, boolean visited[][]){
        
        if( i<0 || i>grid.length || j<0 || j>grid[0].length ) return 0;
        int answer=1;
        visited[i][j] = true;
        if( i!=0 && !visited[i-1][j] && grid[i-1][j]==1 ){
            answer += maxAreaOfIsland(grid,i-1,j,visited);
        }
        if( j!=0 && !visited[i][j-1] && grid[i][j-1]==1 ){
            answer += maxAreaOfIsland(grid,i,j-1,visited);
        }
        if( j!=grid[0].length-1 && !visited[i][j+1] && grid[i][j+1]==1 ){
            answer += maxAreaOfIsland(grid,i,j+1,visited);
        }
        if( i!=grid.length-1 && !visited[i+1][j] && grid[i+1][j]==1 ){
            answer += maxAreaOfIsland(grid,i+1,j,visited);
        }
        return answer;
        
    }
}
