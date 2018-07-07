/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/linked-list-cycle-ii/description/
-------------------------------------------------------

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 

*
*/
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        
        if( head == null )return head;
        
        ListNode oneStep = head;
        ListNode twoStep = head;
        while( twoStep.next != null && twoStep.next.next != null ){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if( oneStep.equals(twoStep) ){
                break;
            }
        }
        if( twoStep.next != null && twoStep.next.next != null ){//found cycle
            
            oneStep = head;
            while( !oneStep.equals(twoStep) ){
                oneStep = oneStep.next;
                twoStep = twoStep.next;
            }
            return oneStep;
            
        }
        else{
            return null;
        }
        
    }
}
