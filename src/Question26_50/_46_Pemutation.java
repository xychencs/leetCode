package Question26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Pemutation {
	public List<List<Integer>> permute(int[] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		List list = new ArrayList<>();
		List temp = new ArrayList<>();
		
		for(int i = 0 ; i < length; i++) {
			temp.add(nums[i]);
		}
		list.add(new ArrayList<>(temp));
		while(nextPermutation(nums)) {
			temp.clear();
			for(int i = 0 ; i < length; i++) {
				temp.add(nums[i]);
			}
			list.add(new ArrayList<>(temp));
		}
		return list;
	}

	public boolean nextPermutation(int[] nums) {

		int len = nums.length;
		if (len <= 0) {
			return false;
		}
		int i = 0;

		for (i = len - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}
		if (i == -1) {
			return false;
		}
		if (i != -1) {
			int swapV = i + 1;
			for (; swapV < len && nums[swapV] > nums[i]; swapV++) {
			}
			int temp = nums[swapV - 1];
			nums[swapV - 1] = nums[i];
			nums[i] = temp;
		}

		changeNums(i + 1, len - 1, nums);
		return true;
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
	
	
	
	/*
		别人优秀的代码
	*/
	 public List<List<Integer>> _permute(int[] nums) {  
	        List<List<Integer>> res = new ArrayList<List<Integer>>();  
	        ArrayList<Integer> temp = new ArrayList<Integer>();  
	        dfs(res, nums, 0);  
	        return res;  
	    }  
	    private void dfs(List<List<Integer>> res, int[] nums, int j) {  
	        if (j == nums.length) {  
	            List<Integer> temp = new ArrayList<Integer>();  
	            for (int num : nums) temp.add(num);  
	            res.add(temp);  
	        }  
	        for (int i = j; i < nums.length; i++) {  
	            swap(nums, i, j);  
	            dfs(res, nums, j+1);  
	            swap(nums, i, j);  
	        }  
	    }  
	    private void swap(int[] nums, int m, int n) {  
	        int temp = nums[m];  
	        nums[m] = nums[n];  
	        nums[n] = temp;  
	    }  
	
	
}
