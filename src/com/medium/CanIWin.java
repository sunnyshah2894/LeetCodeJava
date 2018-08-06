/**
 *		
 */
package com.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/can-i-win/description/
-------------------------------------------------------

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.


*
*/
public class CanIWin {
	Map<String, Boolean> memorization ;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    
        int sum = ( (1+maxChoosableInteger)*maxChoosableInteger) / 2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        memorization = new HashMap<>();
        boolean visited[] = new boolean[ maxChoosableInteger + 1 ];
        return canIWin(desiredTotal,visited);
        
    }
    
    public boolean canIWin(int desiredTotal, boolean visited[] ){
        
        if(desiredTotal <= 0) return false;
        if(desiredTotal < visited.length && !visited[desiredTotal] ) return true;
        
        String key = Arrays.toString(visited);
        
        if( memorization.containsKey(key) ){
            return memorization.get(key) ;
        }
        for( int i=1 ; i<visited.length ; i++ ){
            if( !visited[i] ){
                visited[i] = true;
                if( !canIWin( desiredTotal - i , visited  ) ){
                    // Winning position
                    memorization.put(key,true);
                    visited[i] = false;
                    return true;
                }
                visited[i] = false;
            }
        }
        memorization.put(key,false);
        return false;
    }
    
}
