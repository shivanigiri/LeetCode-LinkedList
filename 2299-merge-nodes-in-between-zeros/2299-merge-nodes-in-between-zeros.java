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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans=new ListNode(-1),temp=ans,curr=head.next;
        int sum=0;
        while(curr!=null){
            if(curr.val==0){
                curr.val= sum;
                temp.next=curr;
                temp=curr;
                sum=0;
            }else{
                sum=sum+curr.val;
            }
            curr=curr.next;
        }
        temp.next=null;
        return ans.next;
    }
}