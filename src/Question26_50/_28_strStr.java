package Question26_50;

public class _28_strStr {
	public int strStr(String haystack, String needle) {
		if (needle == "") {
			return 0;
		}
		return haystack.indexOf(needle);
	}
}
