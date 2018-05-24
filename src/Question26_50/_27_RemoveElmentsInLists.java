package Question26_50;

public class _27_RemoveElmentsInLists {
	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		int first = 0;
		int second = 0;
		for (int i = 0; i < len; i++) {
			if (nums[second] != val) {
				nums[first++] = nums[second];
			}
			second++;
		}
		return first;
	}
}
