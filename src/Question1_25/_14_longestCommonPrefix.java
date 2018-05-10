package Question1_25;

import java.util.Scanner;

public class _14_longestCommonPrefix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  3 ;
		String s[] = new String[3];
		s[0]="abcsss";
		s[1]="abc";
		s[2]="abc";
		System.out.println(longestCommonPrefix(s));
		while(sc.hasNext()) {
			
		}
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0 || strs[0].length()==0) {
			return "";
		}
		int minLength = strs[0].length();
		for(int i = 1 ;i < strs.length;i++) {
			if(strs[i].length()==0) {
				return "";
			}
			if(strs[i].charAt(0)==strs[i-1].charAt(0)) {
				minLength = strs[i].length() < minLength ? strs[i].length() : minLength;  
			}else {
				return "";
			}
		}
		int i = 1;
		while(minLength > i) {
			for(int k = 1 ; k < strs.length; k++) {
				if(strs[k].charAt(i)==strs[k-1].charAt(i)) {
						
				}else {
					minLength = i;
					break;
				}
				if(k==strs.length-1) {
					i++;
				}
			}
		}
		return strs[0].substring(0, i);
	}
}
