package Question26_50;

import java.math.BigDecimal;

public class _50_PowXY {
	public double _myPow(double x, int n) {
		if(n == 0) {
			return 1;
		}
		boolean negetive = false;
		long nn = n;
		if(n<0) {
			negetive = true;
			nn = -nn;
		}
		double result = 1;
		while(nn>0) {
			if( (nn&1) == 1) {
				result *= x;
				if(result > Integer.MAX_VALUE && negetive) {
					return 0.0;
				}
			}
			x *= x;
			nn >>=1;
		}
		if(negetive) {
			result = 1/result;
		}
		
		
		return result;
	}
    public double myPow(double x, int n) {
        double pow = 1.0;
        x = n >= 0 ? x : 1 / x;
        n = (n >= 0) ? n : n * -1;              //虽然当n = -2147483648时，这行语句没效果，但是进入循环结果一致
        while (n != 0) {
            if ((n&1) != 0) { // n % 2 != 0
                pow *= x;
            }
            x *= x;
            n /= 2; // n /= 2
        }
        return pow;
    }
}
