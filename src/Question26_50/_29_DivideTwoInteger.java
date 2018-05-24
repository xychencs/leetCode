package Question26_50;

public class _29_DivideTwoInteger {
	public int divide(int dividend, int divisor) {
		if (dividend == -2147483648 && divisor == (-1)) {
			return Integer.MAX_VALUE;
		}
		int quotient = dividend / divisor;
		return quotient;
	}
}
