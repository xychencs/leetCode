package Question1_25;

import Test.ListNode;

public class _21_MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode l = l1;
		if(l1.val > l2.val){
			l = l2;
			l2 = l2.next;
		}else{
			l1 = l1.next;
		}
		
		ListNode temp = l;
		while(( l1 !=null ) &&( l2!=null )){
			if(l1.val < l2.val){
				temp.next = l1;
				l1 = l1.next;
			}
			else{
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		
		if(l2 != null){
			temp.next = l2;
		}
		if(l1 != null){
			temp.next = l1;
		}
		return l;
		
	}
}
