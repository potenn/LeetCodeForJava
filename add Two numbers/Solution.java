/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
 	ListNode head;
	ListNode end;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


    	head = null;
    	end = null;
    	add(l1,l2,0);

    	return head;

    }

    public void add(ListNode l1, ListNode l2, int carry){

    	if(l1 == null && l2 == null){

    		if(carry ==1){
    			ListNode newNode = new ListNode(carry);

    				end.next = newNode;
    	    		end = end.next;
    		}
    		return;
    	}
    	if(l1 == null){

    		while(l2!=null){

    			int valueOfListNode2 = l2.val + carry;
    			carry = valueOfListNode2 >= 10 ? 1 : 0;
    			ListNode newNode = new ListNode(valueOfListNode2 % 10);

    			end.next = newNode;
    			end = newNode;

    			l2 = l2.next;

    		}
    		if(carry == 1){
    				ListNode carryNode = new ListNode(1);

       				end.next = carryNode;
       				end = carryNode;
    		}
    		return;
    	}


    	if(l2 == null){

    		while(l1!=null){

    			int valueOfListNode1 = l1.val + carry;
    			carry = valueOfListNode1 >= 10 ? 1 : 0;
    			ListNode newNode = new ListNode(valueOfListNode1 % 10);

    				end.next = newNode;
    				end = newNode;
    				l1 = l1.next;
    		}
    		if(carry == 1){
    				ListNode carryNode = new ListNode(1);

        				end.next = carryNode;
        				end = carryNode;
    		}

    		return;
    	}


    	int valueOfListNode1 = l1.val;
    	int valueOfListNode2 = l2.val;
    	int sumOfTwoNodes = valueOfListNode1 + valueOfListNode2 + carry;

    	carry = sumOfTwoNodes >= 10 ? 1 : 0;
    	ListNode newNode = new ListNode(sumOfTwoNodes % 10);
    	if(head == null){
    		head = newNode;
    		end = newNode;
    	}else{
    		end.next = newNode;
    		end = end.next;
    	}
    	add(l1.next,l2.next,carry);
    }

}
