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
	https://github.com/sunnyshah2894
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/coin-change/description/
-------------------------------------------------------

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.


*
*/
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        
        long dp[] = new long[amount+1];
        
        Arrays.fill( dp,Long.MAX_VALUE );
        dp[0] = 0;
        for( int i=0 ; i<coins.length ; i++ ){
            for( int j=coins[i] ; j<=amount ; j++ ){
                if( dp[j-coins[i]] == Long.MAX_VALUE )
                    dp[j] = Math.min( dp[j] , Long.MAX_VALUE );
                else{
                    dp[j] = Math.min( dp[j] , 1+dp[j-coins[i]] );
                }
            }
        }
        if( dp[amount] == Long.MAX_VALUE )
            return -1;
        else return (int)dp[amount];
        
    }
}
