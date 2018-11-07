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
https://leetcode.com/problems/battleships-in-a-board/description/
-------------------------------------------------------

Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

    You receive a valid board, made of only battleships or empty slots.
    Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
    At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

Example:

X..X
...X
...X

In the above board there are 2 battleships.

Invalid Example:

...X
XXXX
...X

This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

*
*/
public class BattleShipsInABoard {
    public int countBattleships(char[][] board) {
        int answer = 0;
        if( board.length == 0 )
            return 0;
        
        for( int i=0 ; i<board.length ; i++ ){
            for( int j=0 ; j<board[0].length ; j++ ){
                if( board[i][j] == 'X' ){
                    boolean isPartOfHorizontal = true;
                    if( ( i-1>=0 && board[i-1][j] == 'X' ) || ( i+1<board.length && board[i+1][j] == 'X' ) ){
                        isPartOfHorizontal = false;
                    }
                    if( isPartOfHorizontal ){
                        if( (j+1<board[0].length && board[i][j+1] == '.') || (j+1>=board[0].length) )
                            answer++;
                    }
                    else{
                        if( (i+1<board.length && board[i+1][j] == '.') || (i+1>=board.length) )
                            answer++;
                    }
                    
                }
            }
        }
        return answer;
    }
}
