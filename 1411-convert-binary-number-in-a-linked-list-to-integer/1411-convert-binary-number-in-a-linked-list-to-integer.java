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
    public int getDecimalValue(ListNode head) {
        if(null==head){
            return 0;
        }
        ListNode curr=head,prev=null,forward=head;
        while(curr!=null){
            forward=forward.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        curr=prev;
        int len=0,ans=0;
        while(curr!=null){
            ans=ans+(int)(Math.pow(2,len))*curr.val;
            len++;
            curr=curr.next;
        }
        return ans;
    }
}