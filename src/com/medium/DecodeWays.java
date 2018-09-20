package com.medium;

/*
 * 
 *
Author:
    Sunny Shah
    sunnyshah452@gmail.com
    https://github.com/sunnyshah2894
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 
------------------------------------------------------- 
https://leetcode.com/problems/decode-ways/description/
-------------------------------------------------------

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


 * 
 */

class DecodeWays {
	public int numDecodings(String s) {

		if (s == null || s.length() == 0)
			return 0;
		char ch[] = s.toCharArray();
		int n = s.length();

		int ans[] = new int[n + 1];

		ans[0] = 1;
		ans[1] = (ch[0] == '0') ? 0 : 1;

		for (int i = 2; i <= n; i++) {
			if (ch[i - 1] <= '9' && ch[i - 1] >= '1')
				ans[i] += ans[i - 1];
			int val = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
			if (val <= 26 && val >= 10)
				ans[i] += ans[i - 2];
		}

		return ans[n];

	}
}