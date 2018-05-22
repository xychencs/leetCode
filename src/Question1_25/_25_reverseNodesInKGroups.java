package Question1_25;

import Test.ListNode;

public class _25_reverseNodesInKGroups {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || k <= 1) {
			return head;
		}
		
		ListNode preFirst = new ListNode(0);
		ListNode preHead = preFirst;
		preFirst.next = head;
		ListNode[] list = new ListNode[k];
		boolean jump = false;
		while(true) {
			int i = 0 ;
			while( k > i) {
				if(head==null) {
					jump = true;
					break;
				}
				list[i] = head;
				head = head.next;
				i++;
			}
			if(jump) {
				break;
			}
			preFirst.next = list[k-1];
			for(int j = k-1 ; j > 0 ;j--) {
				list[j].next = list[j-1];	
			}
			list[0].next = head;
			preFirst = list[0];
		}
		
		return preHead.next;
	}
}
