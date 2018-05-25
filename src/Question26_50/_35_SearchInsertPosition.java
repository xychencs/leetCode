package Question26_50;

public class _35_SearchInsertPosition {
	 public int searchInsert(int[] nums, int target) {
		 int len = nums.length;
		 if(len  == 0) {
			 return -1;
		 }
		 int left = 0 ,right = len - 1;
		 
		 while(left <= right) {
			 int mid = (left+right)/2;
			 if(nums[mid] == target) {
				 return mid;
			 }
			 if(nums[mid] > target) {
				 right = mid - 1;
			 }else {
				 left = mid + 1;
			 }
		 }
		 return left;
	 }
}
