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
https://leetcode.com/problems/fizz-buzz/description/
-------------------------------------------------------


Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*
*/
public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        final String fizz = "Fizz";
        final String buzz = "Buzz";
        final String fizzBuzz = "FizzBuzz";
        
        for( int i=1 ; i<=n ; i++ ){
            if( i%3==0 && i%5==0 )
                result.add( fizzBuzz );
            else if( i%3==0 )
                result.add( fizz );
            else if( i%5==0 )
                result.add( buzz );
            else{
                result.add( Integer.toString(i) );
            }
        }
        return result;
    }
}
