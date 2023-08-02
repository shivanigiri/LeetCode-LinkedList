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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head, temp=new ListNode(-1);
        while(curr != null){
            ListNode prev=temp;
            while(prev.next != null && prev.next.val <= curr.val){
                prev=prev.next;
            }
            ListNode forward=curr.next;
            curr.next=prev.next;
            prev.next=curr;

            curr=forward;
        }
        return temp.next;
    }
}