package Question26_50;

public class _45_JumpGame {
	public int jump(int[] nums) {
		int len = nums.length;
		int jump[] = new int[len];
		int min = Integer.MAX_VALUE - 1;

		if (len == 1) {
			return 0;
		} else if (len == 2) {
			return 1;
		}

		jump[len - 1] = 0;
		jump[len - 2] = 1;
		for (int i = len - 3; i >= 0; i--) {
			for (int j = i + 1; j - i <= nums[i] && j < len; j++) {
				if (min > jump[j]) {
					min = jump[j];
				}
			}
			jump[i] = min + 1;
			min = Integer.MAX_VALUE - 1;
		}

		return jump[0];
	}

	public int _jump(int[] nums) {
		int len = nums.length;
		int ret = 0;
		int maxFar = 0;
		int area = 0;

		for (int i = 0; i < len; i++) {
			if(i > area) {
				area = maxFar;
				ret++;
			}
			maxFar = Math.max(maxFar,i+nums[i] );
		
		}
		return ret;
	}

}
