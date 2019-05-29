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
https://leetcode.com/problems/linked-list-cycle/description/
-------------------------------------------------------

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

*
*/
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if( head == null )return false;
        
        ListNode oneStep = head;
        ListNode twoStep = head;
        while( twoStep.next != null && twoStep.next.next != null ){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if( oneStep.equals(twoStep) ){
                return true;
            }
        }
        return false;
    }
}
