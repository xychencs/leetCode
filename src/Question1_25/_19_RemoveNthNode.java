package Question1_25;

import Test.ListNode;

public class _19_RemoveNthNode {


	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		ListNode last = head;
		if( n <= 0) {
			return null;
		}
			
		while( n > 1) {
			n--;
			last = last.next;
		}
		while(last.next != null) {
			last = last.next;
			first = second;
			second = second.next;
		}
		if(second == head) {
			head =  head.next;
		}else {
			first.next = second.next;
		}
		
		return head;
		
	}
}
