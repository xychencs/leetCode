package Question26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		
		
		HashMap<String,List<String>> map = new HashMap<>();
		for(int i= 0 ; i < strs.length; i++) {
			char[] ca = strs[i].toCharArray();  
	        Arrays.sort(ca); 
	        String keyStr = String.valueOf(ca);  
	        if (!map.containsKey(keyStr)){  
	            map.put(keyStr,new ArrayList<String>());  
	        }  
	        map.get(keyStr).add(strs[i]);  
		}
		
		List ret = new ArrayList<>(map.values());
		
		return ret; 
	}
}
