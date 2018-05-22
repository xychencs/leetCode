package Question1_25;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _20_validParentheses {
	 public boolean isValid(String s) {
		 int len = s.length();
		 Deque<Character>  stack = new LinkedList<Character>();
		 char[] left = {'{','[','('};
		 char[] right = {'}',']',')'};
		 for(int i = 0 ; i < len ; i++ ) {
			 char c = s.charAt(i);
			 int k = 0;
			 for(int j = 0 ; j < 3; j++){
				if( c == left[j]){
					stack.addLast(c);
					continue;
				}
				if(right[j] == (c)){
					 if(stack.isEmpty()) {
						 return false;
					 }
					if(stack.pollLast()==left[j]){
						continue;
					}else{
						return false;
					}
					
				}
			 }
		 }
		 if(!stack.isEmpty()) {
			 return false;
		 }
	     return true;
	 }
}
