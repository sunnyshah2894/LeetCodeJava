/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/excel-sheet-column-number/description/
-------------------------------------------------------

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701

*
*/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0 ;
        int mult = 1;
        char ch[] = s.toCharArray();
        for( int i=ch.length-1 ; i>=0 ; i-- ){
            result += ( ch[i] - 'A' + 1 ) * mult;
            mult *= 26;
        }
        
        return result;
    }
}
