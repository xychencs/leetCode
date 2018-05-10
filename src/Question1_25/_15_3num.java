package Question1_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3num {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums1 = {1,1,-2};
		System.out.println(threeSum(nums1));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if(nums.length < 3) {
			return l;
		}
		Arrays.sort(nums);
		for(int i = 0 ; i < nums.length-2 ;i++){
			if(nums[i]>0 || nums[nums.length-1]<0) {
				break;
			}
			if(i!=0 && nums[i]==nums[i-1]) {
				continue;
			}
			for(int j = nums.length-1 ; j > i+1 ; j--) {
				if(j!=nums.length-1 && nums[j]==nums[j+1]) {
					continue;
				}
				if((0-nums[i]-nums[j])<nums[i] || (0-nums[i]-nums[j])>nums[j]) {
					continue;
				}
				if(binaryFind(nums,i+1,j-1,(0-nums[i]-nums[j]))) {
					List<Integer> col = new ArrayList<>();
					col.add(nums[i]);
					col.add(0-nums[i]-nums[j]);
					col.add(nums[j]);
					l.add(col);
					continue;
				}
			}
		}
		return l;
	}

	public static boolean binaryFind(int arr[], int i , int j , int k) {
		if(arr.length==0 || arr==null) {
			return false;
		}
		if(i==j && arr[i]==k) {
			return true;
		}else if((i==j && arr[i]==k)){
			return false;
		}
		
		while( i <= j ) {
			int mid = (i+j)/2;
			if(arr[mid] == k) {
				return true;
			}
			if(arr[mid] > k) {
				j = mid-1;
			}else {
				i = mid+1;
			}
		}
		return false;
	}
}
