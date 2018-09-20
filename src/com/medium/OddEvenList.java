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
https://leetcode.com/problems/odd-even-linked-list/description/
-------------------------------------------------------

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:

    The relative order inside both the even and odd groups should remain as it was in the input.
    The first node is considered odd, the second node even and so on ...



*
*/
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
        if( head == null ) return null;
        
        ListNode startNode = head;
        ListNode headNode = head.next;
        ListNode nextNode = head.next;
        while( nextNode !=null && nextNode.next != null ){
            startNode.next = nextNode.next;
            startNode = startNode.next;
            nextNode.next = startNode.next;
            startNode.next = headNode;
            nextNode = nextNode.next;
            
        }
        return head;
    }
}
