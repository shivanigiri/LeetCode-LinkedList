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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if(head==null|| head.next==null || left==right)
            return head;
        int i=left, j=right;
        ListNode endL=head,curr=head,startR,revStart=head,revEnd;
        while(i>1){
            endL=curr;
            curr=curr.next;
            i--;
        }
        revStart=curr;
        curr=head;
        while(j>1){
            curr=curr.next;
            j--;
        }
        revEnd=curr.next;
        startR=curr.next;

        curr=revStart;
        ListNode prev=null,forward=curr;
        while(curr!=revEnd){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        if(left==1){ //when reverse involve start of list
            head=prev;
        }else{
        endL.next=prev;
        }
        i=0;
        while(i<right-left){
            prev=prev.next;
            i++;
        }
        prev.next=startR;
    return head;
    }
}