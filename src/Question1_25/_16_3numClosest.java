package Question1_25;

import java.util.Arrays;

public class _16_3numClosest {

	public static void main(String[] args) {
		int []nums = {0,1,2};
		System.out.println(threeSumClosest(nums, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		if(nums.length < 3|| nums==null) {
			return 0;
		}
		int len = nums.length;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int mmm = 0;
		for(int i = 0 ; i < len-2 ; i++) {
			int tempsum;
			int iValue = nums[i];
			int left = i+1;
			int right = len-1;
			while(left < right) {
				int rValue = nums[right];
				int lValue = nums[left];
				tempsum = rValue+lValue+iValue;
				int temp = Math.abs(tempsum-target);
				
				if(temp < min) {
					min = temp;
					mmm = tempsum;
				}
				if(target < tempsum ) {
				
					right--;
				}
				else if(target > tempsum) {
					left ++;
				}else {
					return target;
				}
			}
		}
		
		return mmm;
	}
}
