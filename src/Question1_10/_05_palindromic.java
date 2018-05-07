package Question1_10;

import java.util.Scanner;

//回文串  用的是马拉车算法manacher算法

public class _05_palindromic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(longestPalindrome(s));
		}
	}

	public static String longestPalindrome(String s) {
		char[] a = s.toCharArray();
		char[] c = new char[s.length() * 2 + 2];
		int[] len = new int[s.length() * 2 + 2];
		int maxright = 0;
		int pos = 0;
		int maxpos = 0;
		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			c[2 * i] = '#';
			c[2 * i + 1] = a[i];
		}
		c[s.length() * 2] = '#';
		c[s.length() * 2 + 1] = '-';
		System.out.println(c);
		for (int i = 0; i < c.length - 1; i++) {
			if (i < maxright) {
				len[i] = Math.min(len[2 * pos - i], maxright - i + 1);
			} else {
				len[i] = 1;
			}
			while (i != (len[i] - 1) && c[i - len[i]] == c[i + len[i]]) {
				len[i]++;
			}
			if (len[i] > max) {
				max = len[i];
				maxpos = i;
			}
			if (i + len[i] - 1 > maxright) {
				pos = i;
				maxright = i + len[i] - 1;
			}
		}
		int mid = (maxpos) / 2;
		int length = (len[maxpos]) / 2;
		String ss;
		if (c[maxpos] == '#') {
			ss = s.substring(mid - length, mid + length);
		} else {
			ss= s.substring(mid - length + 1, mid + length);
		}
		return ss;
	}
}
