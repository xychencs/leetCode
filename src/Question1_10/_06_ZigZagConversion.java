package Question1_10;

public class _06_ZigZagConversion {
	public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
		char c[] = s.toCharArray();
		int len;
		if (numRows == 1) {
			len = 1;
		} else {
			len = 2 * (numRows - 1);
		}
		for (int i = 0; i < numRows; i++) {
			int j = i;
			if (j == 0 || j == numRows - 1) {
				while (j < c.length) {
					sb.append(c[j]);
					j = j + len;
				}
			} else {
				int L = 2 * (numRows - 1 - j);
				while (j < c.length) {
					sb.append(c[j]);
					j += L;
					L = len - L;
				}
			}

		}

		return sb.toString();
    }
}
