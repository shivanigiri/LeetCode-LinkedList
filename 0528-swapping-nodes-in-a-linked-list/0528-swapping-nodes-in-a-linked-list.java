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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int len=0,count=1;
        ListNode curr=head, temp1=head,temp2=head;
        while(count<k){
            temp1=temp1.next; //This is node to be swapped
            count++;
        }
        curr=temp1;
        while(curr.next!=null){ //till the time curr reaches end, temp2 will reach desired place
            curr=curr.next;
            temp2=temp2.next;
        }
        int placeHolder= temp1.val;
        temp1.val=temp2.val;
        temp2.val=placeHolder;

        return head;
    }
}