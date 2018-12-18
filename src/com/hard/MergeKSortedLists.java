/**
 *		
 */
package com.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

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
https://leetcode.com/problems/merge-k-sorted-lists/description/
-------------------------------------------------------

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

*
*/
public class MergeKSortedLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>( new Comparator<ListNode>(){
            
            public int compare( ListNode a, ListNode b ){
                return a.val - b.val;
            }
            
        });
        
        for( int i=0 ; i<lists.length ; i++ ){
            if( lists[i] != null )
                pq.offer( lists[i] );
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while( !pq.isEmpty() ){
            
            ListNode nextNode = pq.poll();
            head.next = nextNode;
            head = head.next;
            if( nextNode.next!=null )
                pq.offer( nextNode.next );
            
        }
        return dummy.next;
        
    }
}
