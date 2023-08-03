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
    public int pairSum(ListNode head) {
        if(head.next.next==null){
            return (head.val+head.next.val);
        }
        ListNode slow=head,fast=head,prev=null,head2=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;


        head2=slow;
        prev=null;
        ListNode next=head,curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        int ans=0;
        head=prev;
        while(head!=null && head2!=null){
            ans= Math.max(ans,(head.val+ head2.val));
            head=head.next;
            head2=head2.next;
        }
        return ans;
    }
}