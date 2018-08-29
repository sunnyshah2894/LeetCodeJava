/**
 *		
 */
package com.easy;

import java.util.Arrays;
import java.util.LinkedList;

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
public class RepeatedSubstringPattern {
	
	static int primes[] ;
    public static void sieve(int n){ 
        
		boolean arr[] = new boolean[n + 1];
		Arrays.fill(arr, true);
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!arr[i])
				continue;
			for (int j = 2*i; j <= n; j += i) {
				arr[j] = false;
			}
		}
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 2; i <= n; i++) {
			if (arr[i])
				ll.add(i);
		}
		n = ll.size();

		primes = new int[n];
		for (int i=0 ; i<n; i++) {
			primes[i] = ll.removeFirst();
		}
		return;
        
	}
    
    public boolean repeatedSubstringPattern(String s) {
     
        if( primes == null )
            sieve(10001);
        
        int n = s.length();
        char sch[] = s.toCharArray();
        boolean flag = false;
        for( int i=0 ; i<1229 && primes[i]<=n ; i++ ){
            if( n%primes[i] == 0 ){
                flag = true;
                for( int j=0 ; j<(n/primes[i]) ; j++ ){
                    for( int k=1 ; k<primes[i] ; k++ ){
                        if( sch[j] != sch[ j + (n/primes[i])*k ] ){
                            flag = false;
                        }
                    }
                }
                if( flag )
                    return true;
            }
        }
        return false;
        
    }
}
