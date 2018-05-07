package Question1_10;

import java.util.Scanner;

public class _11_Mostwater {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i = 0 ; i < n;i ++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(maxArea(arr));
		}
	}
	public static int maxArea(int[] height) {
		  int i = 0 , j = height.length;
			if(j == 0 || j == 1) {
				return 0;
			}
			int max = 0;
			int count = 0;
			while(i < j) {
				count = (j-i-1)*(Math.min(height[j-1], height[i]));
				if(count>max) {
					max = count;
				}
				if(height[j-1] < height[i] ) {
					j--;
				}else {
					i++;
				}
				
			}
			return max;
	}
}
