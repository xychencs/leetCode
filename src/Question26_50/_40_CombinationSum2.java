package Question26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _40_CombinationSum2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int length = candidates.length;
//		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		HashSet<ArrayList> set = new HashSet<>();
		iteror(set, new ArrayList<>(), 0, target, candidates);
		List<List<Integer>> list = new ArrayList<>();
		for (ArrayList str : set) {
		      list.add(str);
		}
		return list;
	}

	public void iteror(HashSet result, List l, int cur, int target, int[] candidates) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<>(l));
			return;
		}
		for (int i = cur; i < candidates.length; i++) {

			int key = candidates[i];
			if (key <= target) {
				l.add(key);
				iteror(result, l, i+1, target - key, candidates);
				l.remove(l.size() - 1);
			}else {
				break;
			}
		}

		return;
	}
	
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain == 0) list.add(new ArrayList<>(tempList));
        if(remain > 0){
            for(int i = start; i < nums.length; i++){
                if (remain<nums[i]) break;
                if(i > start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i );
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
