package Question26_50;

public class _43_MutiplyString {
	public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) {
        	return "0";
        }
        
        int len = num1.length();
        int len2 = num2.length();
        String[] str = new String[len];
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = len-1 ; i >= 0; i-- ) {
        	int num = num1.charAt(i)-'0';
        	int carry = 0;
        	for(int key = 0 ; key < len-1-i ;key++) {
        		sb.append(0);
        	}
        	for(int j = len2-1 ; j >= 0 ; j--) {
        		int num_2 = num2.charAt(j)-'0';
        		int sum = num*num_2+carry;
        		int cur = sum%10;
        		carry = sum/10;
        		sb.insert(0, cur);
        	}
        	if(carry != 0) {
        		sb.insert(0, carry);
        	}
        	str[i] = sb.toString();
        	sb.delete(0, sb.length());
        }
        
        
        int leng = str[0].length();
        int carry = 0;
//        int car[] = new int[leng];
        for(int k = 0 ; k < leng ; k++) {
        	int summ = 0;
        	for(int i = 0 ; i < str.length; i++) {
        		if( str[i].length() > k  ) {
        			summ += str[i].charAt(str[i].length()-k-1)-'0';
        		}
        	}
        	summ += carry;
        	carry = summ/10;
        	sb.insert(0, summ%10);
        	
        }
        if(carry!=0) {
        	sb.insert(0, carry);
        }
        
        
        return sb.toString();
    }
}
