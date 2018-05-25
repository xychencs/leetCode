package Question26_50;

public class _33_SearchedInRotatedSortedList {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		// while(left <= right) {
		// int mid = (left + right)/2;
		//
		// if(nums[mid] == target) {
		// return mid;
		// }
		// else if(nums[right] == target) {
		// return right;
		// }
		// else if(nums[left] == target) {
		// return left;
		// }
		// else if (target < nums[mid] && target > nums[left]){
		// right = mid -1;
		// }
		// else if(target < nums[right] && target > nums[mid]) {
		// left = mid +1;
		// }
		// else if(target > nums[mid] && nums[right] < nums[mid] ) {
		// left = mid +1;
		// }
		// else if(target > nums[right] && nums[right] > nums[mid] ) {
		// right = mid -1;
		// }
		// else if(target < nums[right] && nums[right] < nums[mid] ) {
		// left = mid +1;
		// }
		// else if(target < nums[mid] && nums[right] > nums[mid] ) {
		// right = mid -1;
		// }
		// else {
		// return -1;
		// }
		// }

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				return mid;
			}
			if (target > nums[right] && target < nums[left]) {
				return -1;
			}
			if (nums[right] < nums[mid]) {
				if (target > nums[mid]) {
					left = mid + 1;
				} else if (target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			else if (nums[right] > nums[mid]) {
				if (target < nums[mid]) {
					right = mid - 1;
				} else if (target > nums[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

		}
		return -1;
	}

	public int search_(int[] nums, int target) {
		int maxNumber = 0;
		int left = 0;
		int right = nums.length - 1;
		if(right == -1) {
			return -1;
		}
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[left]) {
				right = mid - 1;
			} else if (nums[mid] > nums[left]) {
				left = mid;
			} else {
				if (nums[left] < nums[right]) {
					left = right;
				}
				break;
			}
		}
		maxNumber = left;
		if (target >= nums[0]) {
			left = 0;
			right = maxNumber;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (target == nums[mid])
					return mid;
				else if (target > nums[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
			return -1;
		} else {
			left = maxNumber + 1;
			right = nums.length - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (target == nums[mid])
					return mid;
				else if (target > nums[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
			return -1;
		}
	}
}
