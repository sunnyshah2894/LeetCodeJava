/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/monotone-increasing-digits/description/
-------------------------------------------------------

Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:

Input: N = 10
Output: 9

Example 2:

Input: N = 1234
Output: 1234

Example 3:

Input: N = 332
Output: 299

Note: N is an integer in the range [0, 10^9]. 

*
*/
public class MonotoneIncreasingDigits {
	
    public int monotoneIncreasingDigitsOptimized(int N) {
        String str = String.valueOf(N);
        char [] strs = str.toCharArray();
        int j = strs.length;
        for( int i = strs.length-1; i > 0 ; --i ) {
            if( strs[i] < strs[i-1] ) {
                strs[i-1] -= 1;
                j = i;
            }
        }
        
        
        for(int i = j ; i < strs.length; ++i ) {
            strs[i] = '9';
        }
        
        String tmp2 = new String(strs);
        return Integer.valueOf(tmp2);
    }
    
    public int monotoneIncreasingDigitsMySolution(int N) {
        
        if( N<10 )
            return N;
        else{
            int k = N;
            int monotone = monotone(k);
            while( monotone != k ){
                k = monotone;
                monotone = monotone(k);
            }
            return monotone;
        }
        
    }
    
    public int monotone(int N){
        int ar[] = new int[50];
        int index = 0;
        int N_Backup = N;
        while( N_Backup != 0 ){
            ar[index++] = N_Backup%10;
            N_Backup /= 10;
        }
        int posToChange = index;
        for( int i=index-1 ; i>0 ; i-- ){
            if( ar[i]>ar[i-1] ){
                posToChange = i;
                break;
            }
        }
        if( posToChange == index )
            return N;

        ar[posToChange] = ar[posToChange]-1;
        for( int i=posToChange-1 ; i>=0 ; i-- ){
            ar[i] = 9;
        }

        int answer = 0 ;
        for( int i=index-1 ; i>=0 ; i-- ){
            answer = answer*10 + ar[i];
        }
        return answer;
    }
}
