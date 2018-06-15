package Question1_25;

public class _824_GoatLatin {
    public String toGoatLatin(String S) {
		String[] Str_arr = S.split(" ");
		StringBuilder sb = new StringBuilder("\"");
		int count = 0;
		for (int i = 0; i < Str_arr.length; i++) {
			char a = (char) (Str_arr[i].charAt(0) <= 'U' ? Str_arr[i].charAt(0) + 'a' - 'A' : Str_arr[i].charAt(0));
			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
				sb.append(Str_arr[i]);
			} else {
				sb.append(Str_arr[i].substring(1, Str_arr[i].length()));
				sb.append(Str_arr[i].charAt(0));
			}
			sb.append("ma");
			count++;
			for (int j = 0; j < count; j++) {
				sb.append("a");
			}
			if (i != Str_arr.length - 1) {
				sb.append(" ");
			}
		}
		sb.append("\"");
        S = sb.toString();
		return S;
    }
}
