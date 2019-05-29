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
https://leetcode.com/problems/excel-sheet-column-title/description/
-------------------------------------------------------

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"

*
*/
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuffer result = new StringBuffer();
        
        while( n != 0 ){
            int t = n%26;
            
            if( t == 0 ){
                t = 26;
                n-=26;
            }
            
            result.append( (char)('A' + t - 1) );
            n = n/26;
        }
        result.reverse();
        return result.toString();
    }
}
