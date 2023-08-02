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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        // ListNode curr=head,forward=head,prev=null;
        // head=curr.next;
        // while(curr!=null && curr.next!=null){
        //     forward=curr.next;
        //     curr.next=forward.next;
        //     forward.next=curr;
        //     if(prev!=null){
        //         prev.next=forward;
        //     }
        //     prev=curr;
        //     curr=curr.next;
        // }
        // return head;
        ListNode n1,n2,forward;
        n1=head;
        n2=head.next;
        forward=n2.next;
        
        n2.next=n1;
        n1.next=forward;
        if(forward!=null){
            n1.next=swapPairs(forward);
        }
        return n2;
    }

}