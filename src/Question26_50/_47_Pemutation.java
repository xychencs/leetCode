package Question26_50;

import java.util.ArrayList;
import java.util.List;

public class _47_Pemutation {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List ret = new ArrayList<>();
		fullArraySort(nums,0,nums.length,ret);
		return ret;
	}
	
	public void fullArraySort(int[] nums , int begin ,int end , List ret) {
		if(begin == end) {
			List temp = new ArrayList<>();
			for(int num : nums) temp.add(num);
			ret.add(temp);
			return;
		}
		for(int i = begin ; i < end ; i++) {
			if(!vaild(nums, begin, i)) {
				continue;
			}
			swapArrayElm(nums, begin, i);
			fullArraySort(nums,begin+1,end,ret);
			swapArrayElm(nums, begin, i);
		}
	}
	
	public boolean vaild(int[] nums, int begin , int end) {
		for(int i = begin ; i < end; i++) {
			if(nums[i] == nums[end]) {
				return false;
			}
		}
		return true;
	}
	
	
	public void swapArrayElm(int[] nums, int i , int j ) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
