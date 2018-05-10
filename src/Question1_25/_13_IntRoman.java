package Question1_25;

public class _13_IntRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		romanToInt("MCMXCIV");
	}

	public static int romanToInt(String s) {
		if(s==null|| s.length()==0) {
			return 0;
		}
		int num = 0;
		int arr[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String Roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int i = 0;
		int j = 0;
		int length = s.length();
		while(i < length) {
			int k = 0;
			for( k = j ; k < 13;k++) {
				if(s.substring(i,length).startsWith(Roman[k])) {
					num+=arr[k];
					break;
				}
			}
			i=i+Roman[k].length();;
		}
		return num;
	}
}
