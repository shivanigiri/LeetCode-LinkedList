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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=head,curr=slow,prev=null,forward=slow;
        while(curr!=null){
            forward=curr.next;
            curr.next=prev;;
            prev=curr;
            curr=forward;
        }
       slow=prev;
        while(slow!=null){
            if(slow.val!=temp.val){
                System.out.println(slow.val+" "+temp.val+" ");
                return false;
            }
            slow=slow.next;
            temp=temp.next;
        }
        return true;
        // ListNode temp = head;
        // int num = 0;
        // int rev = 0;
        // int mul = 1;

        // while(temp != null) {

        //     num = num * 10 + temp.val;
        //     rev = rev + temp.val * mul; 
        //     mul *= 10;

        //     temp = temp.next;
        // }

        // return num == rev;
    }
}