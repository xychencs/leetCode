package Question26_50;

public class _34_SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		int len = right;
		if(right == -1) {
			return new int[] { right, right }; 
		}
		int mid = 0;
		int l = 0 ,r = 0;
		boolean F= false;
		while(left <= right) {
			mid = (left+right)/2;
			if(nums[mid] == target) {
				F= true;
				if(mid < len && nums[mid] == nums[mid+1]) {
					left = mid+1;
					continue;
				}else {
					break;
				}
			}
			if(target < nums[mid]) {
				right = mid -1;
			}
			else if(target > nums[mid]) {
				left = mid + 1;
			}
		}
		if(!F) {
			return new int[] { -1,-1 };
		}
		r = mid;
		left = 0;
		right = nums.length-1;
		while(left <= right) {
			mid = (left+right)/2;
			if(nums[mid] == target) {
				if(mid > 0 && nums[mid] == nums[mid-1]) {
					right = mid-1;
					continue;
				}else {
					break;
				}
			}
			if(target < nums[mid]) {
				right = mid -1;
			}
			else if(target > nums[mid]) {
				left = mid + 1;
			}
		}
		l  = mid;
		
		return new int[] { l, r };
	}
	
	public int[] searchRange_(int[] nums, int target) {
		int[] res = new int[]{-1,-1};
		int len = nums.length;
		if(len == 0) {
			return res;
		}
		
		int left = 0 ,right = len - 1;
		while(left <= right && nums[left]!=target && nums[right]!=target) {
			int mid = (left + right)/2;
			if( nums[mid] > target) {
				right = mid - 1;
			}else if( nums[mid] < target ){
				left = mid +1;
			}else {
				break;
			}
		}
		if(left > right) {
			return res;
		}
		while(nums[right] != target) {
			right --;
		}
		while(nums[left] != target) {
			left ++;
		}
		
		return new int[]{left,right};
	}
}
