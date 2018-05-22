package Question1_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4numSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> List = new ArrayList<>();

		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = len - 1; j > i + 2; j--) {
				if (j < len - 1 && nums[j + 1] == nums[j]) {
					continue;
				}

				int tar = target - nums[j] - nums[i];
				int l = i + 1;
				int r = j - 1;
				while (l < r) {
					int tarTemp = nums[l] + nums[r];
					if (tar == (tarTemp)) {
						List<Integer> L = new ArrayList<>();
						L.add(nums[i]);
						L.add(nums[l]);
						L.add(nums[r]);
						L.add(nums[j]);
						List.add(L);
						L = null;
						do {
							l++;
						} while (l<len&&nums[l-1] == nums[l]);
						do {
							r--;
						} while (r>=0&&nums[r+1] == nums[r]);
					}
					if (tar > tarTemp) {
						l++;
					}
					if (tar < tarTemp) {
						r--;
					}
				}
			}
		}
		return List;
	}
}
