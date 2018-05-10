package Question1_25;

import java.util.Scanner;

public class _04_MidNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int num1[] = new int[n1];
			int num2[] = new int[n2];
			for (int i = 0; i < n1; i++) {
				num1[i] = sc.nextInt();
			}
			for (int i = 0; i < num2.length; i++) {
				num2[i] = sc.nextInt();
			}
			double a = findMedianSortedArrays(num1, num2);
			System.out.println(a);
		}
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int L1 = 0, L2 = 0, R1 = 0, R2 = 0, C1, C2, left = 0, right = 2 * nums1.length;
		int m = nums1.length;
		int n = nums2.length;
		while (left <= right) {
			C1 = (left + right) / 2;
			C2 = m + n - C1;

			L1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1 - 1) / 2];
			L2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2 - 1) / 2];
			R1 = (C1 == 2 * m) ? Integer.MAX_VALUE : nums1[C1 / 2];
			R2 = (C2 == 2 * n) ? Integer.MAX_VALUE : nums2[C2 / 2];
			if (L1 > R2) {
				right = C1 - 1;
			} else if (L2 > R1) {
				left = C1 + 1;
			} else {
				break;
			}
		}
		return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;

	}
}