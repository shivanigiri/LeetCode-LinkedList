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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode left=new ListNode(-1);
        ListNode right=new ListNode(-1);
        ListNode curr=head,  tail=right,ans=left;
        while(curr!=null){
            if(curr.val<x){
                left.next=new ListNode(curr.val);
                left=left.next;
            }else{
                right.next=new ListNode(curr.val);
                right=right.next;
            }
            curr=curr.next;
        }
        right.next=null;
        left.next=tail.next;
        return ans.next;
    }
}