/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        List<ListNode> list = new ArrayList<ListNode>();
        if(head == null){
            return null;
        }
        while(head!=null){
            ListNode node = new ListNode(head.val);
            list.add(node);
            head = head.next;
        }

        int len = list.size() - 1;

        ListNode tempHeadNode = list.get(len);
        ListNode pointerNode = tempHeadNode;
        for(int i = len-1 ; i >=0 ; i--){

            ListNode popNode = list.get(i);
            pointerNode.next = popNode;
            pointerNode = popNode;
        }
        return tempHeadNode;
    }
}
