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
https://leetcode.com/problems/ones-and-zeroes/description/
-------------------------------------------------------

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:

    The given numbers of 0s and 1s will both not exceed 100
    The size of given string array won't exceed 600.

Example 1:

Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”

Example 2:

Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

*
*/
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int x[] = new int[strs.length];
        int y[] = new int[strs.length];
        int dp[][][] = new int[strs.length][m+1][n+1];
        
        for( int i=0 ; i<strs.length ; i++ ){
            char str[] = strs[i].toCharArray();
            int count0 = 0, count1 = 0;
            for( int j=0 ; j<str.length ; j++ ){
                if( str[j] == '0' )
                    count0++;
                else count1++;
            }
            x[i] = count0;
            y[i] = count1;
        }
        
        for( int i=0 ; i<strs.length ; i++ ){
            for( int j=0 ; j<=m ; j++ ){
                for( int k=0 ; k<=n ; k++ ){
                    
                    if( j>=x[i] && k>=y[i] && i==0 )
                        dp[i][j][k] = 1;
                    
                    if( i!=0 )
                        dp[i][j][k] = Math.max( dp[i][j][k], dp[i-1][j][k] );
                    
                    if( j>=x[i] && k>=y[i] && i>0 ){
                       dp[i][j][k] = Math.max( dp[i][j][k],1+dp[i-1][j-x[i]][k-y[i]] );
                    }
                    
                }
            }
        }
        
        return dp[strs.length-1][m][n];
    }
}
