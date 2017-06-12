/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0 || lists == null){
            return null;
        }

        PriorityQueue <Integer>pQueue = new PriorityQueue<Integer>(lists.length);

        for(ListNode list : lists){

            ListNode pNode = list;
            while(pNode != null){
                pQueue.offer(pNode.val);
                pNode = pNode.next;
            }
        }

        ListNode newList = new ListNode(0);
        ListNode pNode = newList;

        while(!pQueue.isEmpty()){
            int val = pQueue.poll();
            ListNode newNode = new ListNode(val);
            pNode.next = newNode;
            pNode = newNode;
        }

        return newList.next;


    }
}

// Time Limit 남.
/*

        //sorted된 링크드리스트가 n개 있다.
        //순차적으로 넣으면 됨.(PriorityQueue)
        if(lists.length == 0 || lists == null){
            return null;
        }

        PriorityQueue <Integer>pQueue = new PriorityQueue<Integer>();

        for(ListNode list : lists){

            ListNode pNode = list;
            while(pNode != null){
                pQueue.offer(pNode.val);
                pNode = pNode.next;
            }
        }

        ListNode newList = new ListNode(0);
        ListNode pNode = newList;

        while(!pQueue.isEmpty()){
            int val = pQueue.poll();
            ListNode newNode = new ListNode(val);
            pNode.next = newNode;
            pNode = newNode;
        }

        return newList.next;


        */
