package Question26_50;

public class _31_NextPermutation {
	public void nextPermutation(int[] nums) {

		int len = nums.length;
		if (len <= 0) {
			return;
		}
		int i = 0;

		for (i = len - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}
		
		if(i != -1) {
			int swapV = i + 1;
			for( ;swapV < len && nums[swapV]>nums[i];swapV++) {}
			int temp = nums[swapV - 1];
			nums[swapV - 1] = nums[i];
			nums[i] = temp;
		}
		changeNums(i + 1, len - 1, nums);
	}

	public void changeNums(int left, int right, int[] nums) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
