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
https://leetcode.com/problems/word-search/description/
-------------------------------------------------------

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

*
*/
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        
        int row = board.length , col = board[0].length;
        boolean visited[][] = new boolean[row][col];
        char ch[] = word.toCharArray();
        boolean flag = false;
        for( int i=0 ; i<row ; i++ ){
            for( int j=0 ; j<col ; j++ ){
                if( board[i][j] == ch[0] )
                    flag = flag || exist( board,ch,i,j,0,visited );
            }
        }
        return flag;
    }
    
    public boolean exist(char[][] board, char ch[] , int r , int c , int pos , boolean visited[][]){
        if( r<0 || r>=board.length || c<0 || c>=board[0].length || pos>=ch.length ) return false;
        if( ch[pos] != board[r][c] || visited[r][c] ) return false;
        else{
            visited[r][c] = true;
            boolean flag = false;
            if( pos == ch.length-1 )return true;
            else{
                flag = flag || exist( board, ch , r+1 , c , pos+1, visited );
                flag = flag || exist( board, ch , r-1 , c , pos+1, visited );
                flag = flag || exist( board, ch , r , c+1 , pos+1, visited );
                flag = flag || exist( board, ch , r , c-1 , pos+1, visited );
            }
            visited[r][c] = false;
            return flag;
        }
    }
}
