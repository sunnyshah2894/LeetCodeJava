/**
 *		
 */
package com.medium;

import com.medium.ListNode;

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
https://leetcode.com/problems/merge-two-sorted-lists/description/
-------------------------------------------------------

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


*
*/
public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode currNode = mergedList;
        
        while( l1!=null && l2!=null ){
            if( l1.val <= l2.val ){
                currNode.next = l1;
                l1 = l1.next;
            }
            else{
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        if( l1!=null ){
            currNode.next = l1;
        }
        if( l2!=null ){
            currNode.next = l2;
        }
        return mergedList.next;
        
    }
}
