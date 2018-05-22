package Question1_25;

import java.util.LinkedList;
import java.util.List;

public class _17_Combination_telnumber {
	public List<String> list = new LinkedList<String>();
	public String[] letter = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {
		int len = digits.length();
		if(len <= 0){
			return list;
		}
		char[] arr = new char[len];
		dfs(0,len,arr,digits);
		return list;
	}

	public void dfs(int curDep , int realDep, char[] digits,String arr){
		if(curDep >= realDep){
			list.add(String.valueOf(digits));
			return;
		}
		for(int i = 0 ; i < letter[arr.charAt(curDep)-'0'].length();i++){
			digits[curDep] = letter[arr.charAt(curDep)-'0'].charAt(i);
			dfs(curDep+1,realDep,digits,arr);
		}

	}
	
	
}
