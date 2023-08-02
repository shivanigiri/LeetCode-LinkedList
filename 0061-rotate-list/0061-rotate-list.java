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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return head;
        int len=0,i=0;
        ListNode curr=head, temp=head;
        while(curr!=null && curr.next!=null){
            len++;
            curr=curr.next;
        }
        len++;

        if(k>=len){
            k=k%len;
        }

        if(k==0) return head;

        temp=head;
        i=len-k-1;
        while(i>0){
            i--;
            temp=temp.next;
        }

        curr.next=head;
        head=temp.next;
        temp.next=null;

        return head;
    }
}