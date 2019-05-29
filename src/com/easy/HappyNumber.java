/**
 *		
 */
package com.easy;

import java.util.HashSet;
import java.util.Set;

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
https://leetcode.com/problems/happy-number/description/
-------------------------------------------------------

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1



*
*/
public class HappyNumber {
	public boolean isHappy(int n) {
        return checkIsHappy(n);
    }
    boolean checkIsHappy( int i ){
                    
        Set<Integer> hs = new HashSet<>();

        int t = i;
        while( t!=1 && !hs.contains(t) ){
            hs.add(t);
            int temp = t;
            t=0;
            while( temp!=0 ){
                t += (temp%10)*(temp%10);
                temp /= 10;
            }
        }
        if( t==1 ){
            return true;
        }
        else{
            return false;
        } 

    }
}
