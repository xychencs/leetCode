package Question26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _30_SubStringWithsAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		int sLen = s.length();
		
		int wordsLen = words.length;
		if(sLen <= 0 || wordsLen<=0) {
			return list;
		}
		int wordLen = words[0].length();
		if(wordLen < 0) {
			return list;
		}
		if(wordsLen*wordLen > sLen) {
			return list;
		}
		
		
		HashMap<String, Integer> word = new HashMap<String, Integer>();
		HashMap<String, Integer> tempHash = new HashMap<>();
		int key = 0;
		for(int i = 0 ; i < wordsLen ; i++) {
			if( word.containsKey(words[i])) {
				key = word.get(words[i]);
				word.put(words[i], key+1);
			}else {
				word.put(words[i], 1);
			}
		}
		
		int i = 0 ,j;
		int lastIndex = sLen - wordsLen*wordLen + 1;
		String tempS = null;
		while( i  < lastIndex) {
			tempHash.clear();
			for( j = 0 ; j <wordsLen ; j++) {
				int index = i+wordLen*j;
				tempS = s.substring(index,index + wordLen);
				if(word.containsKey(tempS)) {
					if(tempHash.containsKey(tempS)) {
						if(tempHash.get(tempS)<word.get(tempS)) {
							tempHash.put(tempS, tempHash.get(tempS)+1); 
						}else {
							break;
						}
					}else {
						tempHash.put(tempS, 1);
					}
				}
				else {
					break;
				}
			}
			if(j == wordsLen) {
				list.add(i);
			}
			i++;
		}
		
		
		return list;
	}
}



class Solution {
   	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new LinkedList<Integer>();

		if (words == null || words.length == 0 || s == null || s.equals("")) {
			return res;
		}

		HashMap<String, Integer> freq = new HashMap<String, Integer>();// ͳ��������ÿ���ʳ��ֵĴ���,�����ϣ���д���

		for (String word : words) {
			freq.put(word, freq.containsKey(word) ? freq.get(word) + 1 : 1);
		}// �õ�ÿ���ʵĳ���

		int len = words[0].length();// ��λ��ͳ��
		for (int i = 0; i < len; i++) {// ��һ���µĹ�ϣ��,��¼���������д����ڵ��ʳ��ִ���
			HashMap<String, Integer> currFreq = new HashMap<String, Integer>();// start�Ǵ��ڵĿ�ʼ,count�����������ж��ٴ�
			int start = i, count = 0;

			for (int j = i; j <= s.length() - len; j += len) {
				String sub = s.substring(j, j + len);// ����һ�����Ƿ��Ǹ��������е�
				if (freq.containsKey(sub)) {// �����е��ʳ��ִ�����1
					currFreq.put(sub, currFreq.containsKey(sub) ? currFreq.get(sub) + 1 : 1);
					count++;// ����õ��ʳ��ִ����Ѿ��������������еĴ�����,˵��������һ���õ���,����Ҫ�Ѵ����иõ����ϴγ��ֵ�λ�ü�֮ǰ���е��ʸ�ȥ��
					while (currFreq.get(sub) > freq.get(sub)) {
						String leftMost = s.substring(start, start + len);
						currFreq.put(leftMost, currFreq.get(leftMost) - 1);
						start = start + len;
						count--;
					}// ��������ڵ��������ܵ�����һ��,���ҵ����
					if (count == words.length) {
						String leftMost = s.substring(start, start + len);
						currFreq.put(leftMost, currFreq.get(leftMost) - 1);
						res.add(start);
						start = start + len;
						count--;
					}// ����س����ĵ��ʶ�����������,ǰ������,���¿�ʼ
				} else {
					currFreq.clear();
					start = j + len;
					count = 0;
				}
			}
		}
		return res;
	}
}