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

-------------------------------------------------------

*
*/
public class BestTimeToBuyAndSellStockComplete {
	
	/*
	 * 
	 * Best Time to buy and sell with Transaction fee
	 * 
	 */
	public int maxProfit(int[] prices, int fee) {
        
        long totalOnIthDayIfNothingInHold = 0 ;
        long totalOnIthDayIf1ShareInHold = Integer.MIN_VALUE;
        
        for( int price: prices ){
            
            long backupTotalOnIthDayIfNothingInHold = totalOnIthDayIfNothingInHold;
            totalOnIthDayIfNothingInHold = Math.max( totalOnIthDayIfNothingInHold , totalOnIthDayIf1ShareInHold + price - fee );
            totalOnIthDayIf1ShareInHold = Math.max( totalOnIthDayIf1ShareInHold , backupTotalOnIthDayIfNothingInHold - price );
            
        }
        
        return (int)totalOnIthDayIfNothingInHold;
    }
	
	/*
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
	 * 
	 * Best Time to buy and sell multiple times
	 * 
	 */
	public int maxProfit2(int[] prices) {
        
        long totalOnIthDayIfNothingInHold = 0 ;
        long totalOnIthDayIf1ShareInHold = Integer.MIN_VALUE;
        
        for( int price: prices ){
            
            long backupTotalOnIthDayIfNothingInHold = totalOnIthDayIfNothingInHold;
            totalOnIthDayIfNothingInHold = Math.max( totalOnIthDayIfNothingInHold , totalOnIthDayIf1ShareInHold + price );
            totalOnIthDayIf1ShareInHold = Math.max( totalOnIthDayIf1ShareInHold , backupTotalOnIthDayIfNothingInHold - price );
            
        }
        
        return (int)totalOnIthDayIfNothingInHold;
    }
	
	/*
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	 * 
	 * Best Time to buy and sell with only 1 transaction allowed
	 * 
	 */
	public int maxProfit3(int[] prices) {
        
        long totalOnIthDayIfNothingInHold = 0 ;
        long totalOnIthDayIf1ShareInHold = Integer.MIN_VALUE;
        
        for( int price: prices ){
            
            totalOnIthDayIfNothingInHold = Math.max( totalOnIthDayIfNothingInHold , totalOnIthDayIf1ShareInHold + price );
            totalOnIthDayIf1ShareInHold = Math.max( totalOnIthDayIf1ShareInHold ,  -price );
            
        }
        
        return (int)totalOnIthDayIfNothingInHold;
    }
	
	/*
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
	 * 
	 * Best Time to buy and sell with only 2 transaction allowed
	 * 
	 */
	public int maxProfit5(int[] prices) {
        
		long ti20 = 0;
        long ti10 = 0;
        long ti21 = Integer.MIN_VALUE;
        long ti11 = Integer.MIN_VALUE;
        
        for( int price: prices ){
            ti20 = Math.max( ti20 , ti21 + price );
            ti21 = Math.max( ti21 , ti10 - price );
            ti10 = Math.max( ti10 , ti11 + price );
            ti11 = Math.max( ti11 , -price );
        }
        
        return (int)ti20;
    }
	
	
	/*
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
	 * 
	 * Best Time to buy and sell with cooldown period between 2 transactions
	 * 
	 */
	public int maxProfit6(int[] prices) {
        
		long totalOnIthDayIfNothingInHold = 0 ;
        long totalOnIthDayIf1ShareInHold = Integer.MIN_VALUE;
        long twoDaysOldBackup = 0;
        
        for( int price: prices ){
            
            long backupTotalOnIthDayIfNothingInHold = totalOnIthDayIfNothingInHold;
            totalOnIthDayIfNothingInHold = Math.max( totalOnIthDayIfNothingInHold , totalOnIthDayIf1ShareInHold + price );
            totalOnIthDayIf1ShareInHold = Math.max( totalOnIthDayIf1ShareInHold , twoDaysOldBackup - price );
            twoDaysOldBackup = backupTotalOnIthDayIfNothingInHold;
        }
        
        return (int)totalOnIthDayIfNothingInHold;
    }
	/*
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
	 * 
	 * Best time to buy and sell stock with at most k transactions
	 * 
	 */
	public int maxProfit7(int k, int[] prices){
		
		k = Math.min( prices.length/2 , k);
		
		int[] Tik0 = new int[k + 1];
	    int[] Tik1 = new int[k + 1];
	    Arrays.fill(Tik1, Integer.MIN_VALUE);
	        
	    for (int price : prices) {
	        for (int j = k; j > 0; j--) {
	            Tik0[j] = Math.max(Tik0[j], Tik1[j] + price);
	            Tik1[j] = Math.max(Tik1[j], Tik0[j - 1] - price);
	        }
	    }
	        
	    return Tik0[k];
	}
	
	
}
