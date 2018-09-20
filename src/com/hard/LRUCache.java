/**
 *		
 */
package com.hard;

import java.util.HashMap;
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
https://leetcode.com/problems/lru-cache/description/
-------------------------------------------------------

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); // capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


*
*/
class LRUCache {

    class Node{
		int val;
		int key;
		Node next;
		Node prev;
		Node(int key,int val){
			this.val = val;
			this.key = key;
		}
	}
	
	class DLL{
		Node head;
		int size = 0;
		Node rear;
		int capacity = 0;
		DLL( int capacity ){
			this.capacity = capacity;
			this.head = null;
			this.rear = null;
		}
		
		Node addAtEnd( int key,int val ){
			Node temp = new Node(key,val);
			if( rear == null ){
				head = temp;
				rear = temp;
				size++;
			}
			else{
				if( size == capacity ){
					rear.prev.next = temp;
				}
				else{
					rear.next = temp;
					size++;
				}
				temp.prev = rear;
				rear = temp;
			}
			return rear;
		}
		
		void delete( Node nodeToDel ){
			if( rear == null && head == null ){
				return;
			}
			else{
				Node prevNode = nodeToDel.prev;
				Node nextNode = nodeToDel.next;
                if( prevNode == null )
                    head = nodeToDel.next;
                else prevNode.next = nextNode;
                
                if( nextNode == null )
                    rear = prevNode;
                else   
				    nextNode.prev = prevNode;
				size--;
			}
		}
		
		Node deleteFirst( ){
			if( rear == null && head == null ){
				return null;
			}
			else{
                Node temp = head;
				head = head.next;
                if( head != null )
                    head.prev = null;
				size--;
                return temp;
			}
		}
		
	}
	
	int size = 0;
	DLL myDLL;
	Map<Integer,Node> map;
    public LRUCache(int capacity) {
    	myDLL = new DLL(capacity);
    	map = new HashMap<>(); 	
    }
    
    public int get(int key) {
    	int returnValue = -1;
    	if( myDLL.size == 0 || !map.containsKey(key) ){
    		return returnValue;
    	}
    	else{
    		if( map.containsKey( key ) ){
    			Node node = map.get(key);
    			returnValue = node.val;
    			myDLL.delete(node);
    			map.put(key,myDLL.addAtEnd(key, returnValue));
    		}
    	}
    	return returnValue;
    }
    
    public void put(int key, int value) {
    	if( map.containsKey( key ) ){
    		Node node = map.get(key);
			myDLL.delete(node);
			map.put(key,myDLL.addAtEnd(key, value));
    	}
    	else{
            if( myDLL.size == myDLL.capacity ){
                Node deleted = myDLL.deleteFirst();
                map.remove(deleted.key);
            }
            map.put(key,myDLL.addAtEnd(key, value));
    	}
    }
	
	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
