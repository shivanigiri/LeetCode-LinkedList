/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
         if(lists.length==1){
            return lists[0];
        }
        ListNode ans=new ListNode(-1), temp=ans;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int count=0;
        while(count<lists.length){
            ListNode curr=lists[count];
            while(curr!=null){
                pq.add(curr.val);
                curr=curr.next;
            }
            count++;
        }
        while(!pq.isEmpty()){
            ListNode node=new ListNode(pq.poll());
            temp.next=node;
            temp=temp.next;
        }
        return ans.next;
    }
}