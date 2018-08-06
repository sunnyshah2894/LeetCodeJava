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
https://leetcode.com/problems/next-greater-element-iii/description/
-------------------------------------------------------

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21

 

Example 2:

Input: 21
Output: -1


*
*/
public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
        
        int ar[] = new int[100];
        int temp = n, index = 0;
        
        while( temp!=0 ){
            ar[index++] = temp%10;
            temp /= 10;
        }
        boolean isSorted = true;
        for( int i=0; i<index-1; i++ ){
            if( ar[i] > ar[i+1] ){
                isSorted = false;
            }
        }
        if( isSorted )return -1;
        else{
            int firstMaxIndex = 0;
            int firstMinIndex = 0;
            boolean flag = false;
            System.out.println( Arrays.toString(ar) );
            for( int i=0 ; i<index ; i++ ){
                for( int j=i+1 ; j<index ; j++ ){
                    if( ar[i] > ar[j] && (firstMinIndex > j || firstMinIndex == 0) ){
                        int t1=ar[firstMaxIndex];ar[firstMaxIndex]=ar[firstMinIndex];ar[firstMinIndex]=t1;
                        t1=ar[i];ar[i]=ar[j];ar[j]=t1;
                        firstMaxIndex=i;firstMinIndex=j;
                        flag = true;
                        break;
                    }
                }
            }
            
            Arrays.sort( ar,0,firstMinIndex);
            
            long answer = 0;
            for( int i=index-1 ; i>=firstMinIndex ; i-- ){
                answer = answer*10 + ar[i];
            }
            for( int i=0;i<firstMinIndex;i++ ){
                answer = answer*10 + ar[i];
            }

            return (answer>Integer.MAX_VALUE)?-1:(int)answer;
              
        }
        
    }
}
