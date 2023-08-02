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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode start=head;
        ListNode end=head;
        ListNode prev=null,slow=head,fast=head;
        int flag=0;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null; //making first half as one linkedList
        start=head;
        end=slow;

        ListNode curr=end,forward=end;
        prev=null;
        while(curr!=null){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        end=prev; //(3,4,5)
        prev=null;
        ListNode tempE=end, tempO=start, ans=start;
        //considering first half as main list and adding one by one node of 2nd half in middle of first.
        while(start!=null && end!=null){
            tempO=start.next;
            tempE=end.next;
            start.next=end;
            end.next=tempO;

            prev=end;
            end=tempE;
            start=tempO;
        }
        //ans= 1,5,2,4
        if(end!=null){ //if len is odd then add last node (1,2,3,4,5)
            prev.next=end;
        }
        //ans= 1,5,2,4,3
        head=ans;
        //return head;
    }
}