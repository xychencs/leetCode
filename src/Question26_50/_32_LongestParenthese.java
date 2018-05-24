package Question26_50;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _32_LongestParenthese {
	public int longestValidParentheses(String s) {
		Deque<Integer> list = new LinkedList<Integer>();
		int max = 0;
		int cur = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && !list.isEmpty() && s.charAt(list.peekLast()) == '(') {
				list.removeLast();
				if (list.isEmpty()) {
					max = i + 1;
				} else {
					if (i - list.peekLast() > max) {
						max = i - list.peekLast();
					}
				}
			} else {
				list.addLast(i);
			}
		}
		return max;
	}

	public int longestValidParentheses_(String s) {
		int dp[] = new int[s.length()];
		int max = 0;
		int len = s.length();
		for (int i = 1; i < len; i++) {
			if (s.charAt(i) == '(') {
				continue;
			} else {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i > 2) ? dp[i - 2] + 2 : 2;
					if (dp[i] > max) {
						max = dp[i];
					}
				} else {
					int location = i - dp[i - 1] - 1;
					if (location >= 0 && s.charAt(location) == '(') {
						dp[i] = dp[i - 1] + 2;
						if(location >=1) {
							dp[i] = dp[i] + dp[location-1];
						}
						if (dp[i] > max) {
							max = dp[i];
						}
					}
				}
			}
		}
		return max;
	}
}
