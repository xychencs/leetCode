package Question1_25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import Test.ListNode;

public class _23_MergeNSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}
		int i = 0 ;
		int j = lists.length-1;
		while( j > 0) {
			i = 0 ;
			while( i < j ) {
				lists[i] = merge(lists[i], lists[j]);
				i ++;
				j --;
			}
		}
		return lists[0];
		
	}
	
	public ListNode merge(ListNode first , ListNode second) {
		if(first == null) {
			return second;
		}
		if(second == null) {
			return first;
		}
		ListNode pHead = null;
		if( first.val < second.val ) {
			pHead = first;
			pHead.next = merge(first.next, second);
		}
		else {
			pHead = second;
			pHead.next = merge(first, second.next);
		}
		return pHead;
	}
	
	
	
	
	public ListNode mergeKLists_(ListNode[] lists) {
		int len = lists.length;
		if (len == 0) {
			return null;
		}
		ListNode min = null;
		ListNode head = null;
		ListNode temp = null;
		List<ListNode> arr = new LinkedList<>();
		for(int i = 0 ; i < len ; i++) {
			if(lists[i] != null) {
				InsertList(arr,lists[i]);
				if(min == null) {
					min = lists[i];
				}
				if(min.val > lists[i].val) {
					min = lists[i];
				}
			}
		}
		if(min == null) {
			return null;
		}
		head = temp = min;
		arr.remove(min);
		if(min.next!=null) {
			InsertList(arr, min.next);
		}
		while(arr.size()>0) {
			ListNode tempNode = arr.remove(0);
			temp.next = tempNode;
			temp = temp.next;
			
			if(tempNode.next == null) {
				continue;
			}else {
				while(tempNode.next!=null &&arr.size()>0&& tempNode.next.val <=arr.get(0).val) {
					
					temp = temp.next;
					tempNode = temp;
				}
				if(tempNode.next != null) {
					InsertList(arr,tempNode.next );
				}
			}
		}
		return head;
	}
	
	public void InsertList(List<ListNode> arr , ListNode node) {
		if(arr==null) {
			arr.add(node);
			return;
		}
		int l = 0 ; 
		int r = arr.size()-1;
		int value = node.val;
		while(l <= r) {
			int k = (l+r)/2;
			ListNode temp = arr.get(k);
			int tempV = temp.val;
			if (value == tempV) {
				arr.add(k, node);
				return;
			}
			if(value > tempV) {
				l = k+1;
			}else {
				r = k-1;
			}
		}
		arr.add(l,node);
		return ;
	}
}
