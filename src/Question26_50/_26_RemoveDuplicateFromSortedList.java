package Question26_50;

public class _26_RemoveDuplicateFromSortedList {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		int length = 1;
		for (int i = 1; i < len; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				nums[length] = nums[i];
				length++;
			}
		}
		return length;
	}
}
