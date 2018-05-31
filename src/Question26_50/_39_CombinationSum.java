package Question26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int length = candidates.length;
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		iteror(list, new ArrayList<>(), 0, target, candidates);
		return list;
	}

	public void iteror(List result, List l, int cur, int target, int[] candidates) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<>(l));
			return;
		}
		for (int i = cur; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1]) {
				continue;
			}
			int key = candidates[i];
			if (key <= target) {
				l.add(key);
				iteror(result, l, i, target - key, candidates);
				l.remove(l.size() - 1);
			} else {
				break;
			}
		}

		return;
	}
}
