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

    public ListNode reverseKGroup(ListNode head, int k) {
         if(head==null || head.next==null){
            return head;
         }
        ListNode curr=head, kTail=null,newHead=null;
        while(curr!=null){
            int count=0;
            while(curr!=null && count<k){
             count++;
             curr=curr.next; // curr is at (k+1)th place after loop ends.
            }

            if(count==k){ //we need to reverse k part
                ListNode revHead=reverse(head,k);
                if(newHead==null){
                    newHead=revHead;
                }
                if(kTail!=null){
                    kTail.next=revHead;
                }
                kTail=head;//after reverse head becomes end of that reverses part hence tail=head.
                head=curr;//everyTime we updating head as curr which is at (k+1)th node.
            }
        }
        //attach remaining part if that is there.
        if(kTail!=null){
            kTail.next=head;
        }
        //if whole list is less than k then no reverse.
        if(newHead==null){
            return head;
        }
        return newHead;
    }
    public ListNode reverse(ListNode head, int k){
        ListNode prev_NewHead = null, curr=head, next=head;
        while(k>0){
            next=curr.next;
            curr.next=prev_NewHead;
            prev_NewHead=curr;
            curr=next;
            k--;
        }
        return prev_NewHead;
    }
}