/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
-------------------------------------------------------

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:

    The length of both lists will be in the range of [1, 1000].
    The length of strings in both lists will be in the range of [1, 30].
    The index is starting from 0 to the list length minus 1.
    No duplicates in both lists.



*
*/
public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> list2Mapper = new HashMap<>();
        int index = 0 ;
        for( String s: list2 ){
            list2Mapper.put( s, index++ );
        }
        
        index = 0;
        List<String> answer = new ArrayList<>();
        int currMin = Integer.MAX_VALUE;
        for( String s: list1 ){
            if( index > currMin )break;
            if( list2Mapper.containsKey(s) ){
                int pos = list2Mapper.get(s);
                if( currMin == (pos + index) ){
                    answer.add(s);
                }
                else if( currMin > (pos + index) ){
                    answer.clear();
                    answer.add(s);
                    currMin = (pos + index);
                }
            }
            index++;
        }
        String answerArray[] = new String[answer.size()];
        return answer.toArray(answerArray);
        
    }
}
