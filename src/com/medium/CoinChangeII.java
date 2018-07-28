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
https://leetcode.com/problems/coin-change-2/description/
-------------------------------------------------------

You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Note: You can assume that

    0 <= amount <= 5000
    1 <= coin <= 5000
    the number of coins is less than 500
    the answer is guaranteed to fit into signed 32-bit integer

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

 

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

 

Example 3:

Input: amount = 10, coins = [10] 
Output: 1


*
*/
public class CoinChangeII {
	
	/*
	 *  My approach :
	 *   
	 *   dp[ i ] [ j ]  --> total ways to make i with first j coins
	 *   
	 *   dp[ i ] [ j ]  --> should always look at dp[i-coins[j] ][j] + dp[i-coins[j] ][j-1] .... dp[i-coins[j] ][0]
	 *   					^ this ensures that we do not have duplicate combinations. 
	 *   
	 *   The below code optimizes the above approach, by propagating DP values instead of checking the
	 *   DP values each time.
	 *   
	 */
	public int change(int amount, int[] coins) {
        
        if( amount == 0 ) return 1;
        int dp[][] = new int[amount+1][coins.length];
        
        Arrays.sort( coins );
        int total = 0;
        
        for( int i=1; i<=amount ; i++ ){
            total = 0;
            for( int j=coins.length-1 ; j>=0 ; j-- ){
                if( coins[j] == i ){
                    dp[i][j] = dp[i][j] + 1;
                }
                total += dp[i][j];
                
                if( i+coins[j] <= amount ){
                    dp[i+coins[j]][j] += total;    
                }
                
            }
        }
        return total;
    }
	/*
	 *  Much better and optimized solution
	 *  
	 *  In the above solution, we only care about dp[amount][0] + dp[amount][1] + ... + dp[amount][coins.length-1]
	 *  
	 *  So, to optimize we can reduce the dp array to 1 dimension as follows.
	 *  
	 */
	public int changeII(int amount, int[] coins) {
        
        int dp[] = new int[amount+1];
        dp[0] = 1;
        
        for( int coin: coins ){
            for( int i=coin ; i<=amount ; i++ ){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
        
    }
	
	
	
}
