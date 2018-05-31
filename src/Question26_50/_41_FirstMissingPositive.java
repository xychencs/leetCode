package Question26_50;

public class _41_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int key = i;
			while ((key >= 0 && key < len + 1) && nums[key] != key + 1) {
				if (nums[key] > 0 && nums[key] < len + 1) {
					if (nums[key] == nums[nums[key]-1]) {
						break;
					}
					int temp = nums[key];
					nums[key] = nums[nums[key] - 1];
					nums[temp - 1] = temp;

				} else {
					break;
				}
			}
			continue;
		}
		int i = 0;
		for (i = 0; i < len && nums[i] == (i + 1); i++) {
		}
		return i + 1;
	}
}
