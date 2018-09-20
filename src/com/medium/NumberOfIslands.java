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
https://leetcode.com/problems/number-of-islands/description/
-------------------------------------------------------

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

*
*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        if( grid.length == 0 )
            return 0;
        int answer = 0 ;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for( int i=0 ; i<grid.length ; i++ ){
            for( int j=0 ; j<grid[0].length ; j++ ){
                if( grid[i][j] == '1' && !visited[i][j] ){
                    answer++;
                    dfs( i,j,visited,grid );
                }
            }
        }
        
        return answer;
        
    }
    public void dfs( int i, int j, boolean visited[][] , char[][] grid ){
        if( i<0 || j<0 || i>= visited.length || j>=grid[0].length ){
            return;
        }
        else{
            if( grid[i][j] == '0' )return;
            if( visited[i][j] )return;
            visited[i][j] = true;
            dfs( i,j-1,visited,grid );
            dfs( i-1,j,visited,grid );
            dfs( i,j+1,visited,grid );
            dfs( i+1,j,visited,grid );
        }
    }
}
