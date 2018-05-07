package Question1_10;

import java.util.Scanner;

public class _12_RomanInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int i = sc.nextInt();
			System.out.println(intToRoman(i));
		}
	}
	/*
			该题的经典算法，可读性，简易性和效率都很高
	
	*/
//	   public String intToRoman(int num) {
//	        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//	        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//	        StringBuilder sb = new StringBuilder();
//	        for (int i = 0; i < values.length; i++) {
//	            while (num >= values[i]) {
//	                num -= values[i];
//	                sb.append(strs[i]);
//	            }
//	        }
//	        return sb.toString();
//	    }
	
	
	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		String a = String.valueOf(num);
		int len = a.length();
		if(a.length()==4) {
			for(int i = 0 ; i < a.charAt(0)-'0';i++) {
				sb.append("M");
			}
		}
		if(a.length()>=3) {
			int value = a.charAt(len-3)-'0';
			if( value== 4 ) {
				sb.append("CD");
				
			}else if( value == 9) {
				sb.append("CM");
			}else if( value >= 5) {
				sb.append("D");
				for(int i = 0 ; i < value-5;i++) {
					sb.append("C");
				}
			}else {
				for(int i = 0 ; i < value;i++) {
					sb.append("C");
				}
			}
		}
		if(a.length()>=2) {
			int value = a.charAt(len-2)-'0';
			if( value== 4 ) {
				sb.append("XL");
				
			}else if( value == 9) {
				sb.append("XC");
			}else if( value >= 5) {
				sb.append("L");
				for(int i = 0 ; i < value-5;i++) {
					sb.append("X");
				}
			}else {
				for(int i = 0 ; i < value;i++) {
					sb.append("X");
				}
			}
		}
		if(a.length()>=1) {
			int value = a.charAt(len-1)-'0';
			if( value== 4 ) {
				sb.append("IV");
				
			}else if( value == 9) {
				sb.append("IX");
			}else if( value >= 5) {
				sb.append("V");
				for(int i = 0 ; i < value-5;i++) {
					sb.append("I");
				}
			}else {
				for(int i = 0 ; i < value;i++) {
					sb.append("I");
				}
			}
		}
		return sb.toString();
	}
}
