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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        int len=getLen(head);
        n=len-n;
        while(n>0){
            n--;
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return dummy.next;
    }
    public int getLen(ListNode head){
        int ans=0;
        while(head!=null){
            ans++;
            head=head.next;
        }
        return ans;
    }
}