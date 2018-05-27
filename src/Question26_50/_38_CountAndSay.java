package Question26_50;

public class _38_CountAndSay {
	public String countAndSay(int n) {
		if(n<=0) {
			return null;
		}
		if(n == 1 ) {
			return "1";
		}
		String s = "1";
		for(int i = 1 ; i < n ; i++) {
			s = getValue(s);
		}
		return s;
	}
	
	public String getValue(String s) {
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		int length = 1;
		for(int i = 0 ; i < len ; i++) {
			while(i< len -1 && s.charAt(i)==s.charAt(i+1)) {
				length++;
				i++;
			}
			sb.append(String.valueOf(length));
			sb.append(s.charAt(i));
			length = 1;
		}
		return sb.toString();
	}
}
