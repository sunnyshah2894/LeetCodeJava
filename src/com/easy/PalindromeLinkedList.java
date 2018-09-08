package com.easy;

import java.io.*;
import java.util.*;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public boolean isPalindrome(ListNode head) {
		ListNode singlePointer = head;
		ListNode doublePointer = head;
		while (doublePointer != null) {
			singlePointer = singlePointer.next;
			doublePointer = doublePointer.next;
			if (doublePointer == null)
				break;
			doublePointer = doublePointer.next;
		}
		doublePointer = head;
		singlePointer = reverseLinkedList(singlePointer);
		while (singlePointer != null) {
			if (doublePointer.val != singlePointer.val)
				return false;
			singlePointer = singlePointer.next;
			doublePointer = doublePointer.next;

		}
		return true;

	}

	private ListNode reverseLinkedList(ListNode singlePointer) {
		ListNode prevNode = null;

		while (singlePointer != null) {
			ListNode nextNode = singlePointer.next;
			singlePointer.next = prevNode;
			prevNode = singlePointer;
			singlePointer = nextNode;
		}
		singlePointer = prevNode;
		return singlePointer;
	}
}

class PalindromeLinkedList {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode head = stringToListNode(line);
			boolean ret = new Solution().isPalindrome(head);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}
}