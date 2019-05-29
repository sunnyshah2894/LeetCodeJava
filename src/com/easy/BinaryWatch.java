/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/binary-watch/description/
-------------------------------------------------------

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

Note:

    The order of output does not matter.
    The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
    The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".


*
*/
public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        List<Integer> bitReps[] = new ArrayList[10];
        
        for( int i=0 ; i<60 ; i++ ){
            int noBits = Integer.bitCount(i);
            if( bitReps[noBits] == null ){
                bitReps[noBits] = new ArrayList<Integer>();
            }
            bitReps[noBits].add(i);
        }
        List<String> answer = new ArrayList<>();
        
        for( int i=0 ; i<=4 ; i++ ){
            int min = num-i;
            if( min<6 && min>=0 ){
                for( int hrs: bitReps[i] ){
                    if( hrs > 11 ){
                        break;
                    }
                    else{
                        String hr = Integer.toString(hrs);
                        for( int mins : bitReps[min] ){
                            if( mins <= 9 ){
                                answer.add( hr + ":0" + Integer.toString(mins) );
                            }
                            else answer.add( hr + ":" + Integer.toString(mins) );
                        }
                    }

                }
                
            }
        }
        
        return answer;
        
    }
}
