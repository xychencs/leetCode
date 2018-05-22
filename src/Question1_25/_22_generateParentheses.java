package Question1_25;

import java.util.ArrayList;
import java.util.List;

public class _22_generateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        addParenthese(n,n,"",list);
		return list;
    }
	
	public void addParenthese(int left , int right , String s , List l){
		if(left == 0 ){
			for(int i = 0 ; i < right ; i++){
				s +=")";
			}
			l.add(s);
			return;
		}
		if(right > left){
			addParenthese(left,right-1,s+")",l);
		}
		addParenthese(left-1,right,s+"(",l);
	}
}
