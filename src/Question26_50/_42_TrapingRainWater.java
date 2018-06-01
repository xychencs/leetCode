package Question26_50;

public class _42_TrapingRainWater {
	public int trap(int[] height) {
		int area = 0;

		int len = height.length;
		if (len == 0) {
			return 0;
		}

		int l = 0, r = len - 1;
		int lMax = 0, rMax = 0;

		while (l < r) {
			lMax = Math.max(lMax, height[l]);
			rMax = Math.max(rMax, height[r]);
		
			if(lMax < rMax) {
				area += (lMax - height[l]);
				l++;
			}else {
				area += (rMax - height[r]);
				r--;
			}
		
		}

		return area;
	}
}
