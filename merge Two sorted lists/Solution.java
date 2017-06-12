/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

	/*
	문제 해결 전략
	L1과 L2의 길이에 따라 상황을 구분한다.
	1. L1 < L2
	2. L1 > L2
	3. L1 == L2
	4. L1이 null *
	5. L2가 null *
	6. L1과 L2가 둘다 null *

	1. Fake로 Head 만들어 놓음 계속 연결시켜놓을것
	2. 그리고 지속해서 움직힐 Pointer P도 만들어 놓을것.
	3. l1과 l2는 움직여도 상관이 없는게 P가 붙잡고 있으므로 상관이 없다.

	*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    	ListNode head = new ListNode(0);
    	ListNode pointer = head;

    	while(l1 != null || l2 != null){

    		if(l1 != null && l2 != null){

    			if(l1.val < l2.val){
    				pointer.next = l1;
    				l1 = l1.next;
    			}else{
    				pointer.next = l2;
    				l2 = l2.next;
    			}

    			pointer = pointer.next;

    		}else if(l1 == null){
    			pointer.next = l2;
    			break;
    		}else if(l2 == null){
    			pointer.next = l1;
    			break;
    		}
    	}

    	return head.next;
    }


}
