/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next!=null && head==head.next){
            return head;
        }
        ListNode slow=head,fast=head;
        boolean flag=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag=true;
                break;
            }
        }
        if(!flag){
            return null;
        }
        fast=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}