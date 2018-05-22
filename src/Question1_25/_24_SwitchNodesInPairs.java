package Question1_25;

import Test.ListNode;

public class _24_SwitchNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode prehead = new ListNode(0) ;
		prehead.next = head;
		ListNode preFirst = prehead ;
		ListNode first = head ;
		ListNode second = head ;
		ListNode third = head ;
		if(head.next==null) {
			return head;
		}
		second = head.next;
		
		while( second != null ) {
			preFirst.next = second;
			third = second.next;
			second.next = first;
			first.next = third;
			preFirst = first;
			first = third;
			second = null;
			if(first != null) {
				second = first.next;
			}
		}
		return prehead.next;
	}
}
