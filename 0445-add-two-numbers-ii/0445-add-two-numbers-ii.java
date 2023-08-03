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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(), temp=result;
       int carry=0, ans=0;
       l1=getReverse(l1);
        l2=getReverse(l2);
       while(l1!=null && l2!=null){
           ListNode node=new ListNode();
           ans=l1.val+l2.val+carry;
           carry=0;
           if(ans>=10){
               carry=1;
                ans=ans-10;
           }
           node.val=ans;
           temp.next=node;
           temp=temp.next;
           l1=l1.next;
           l2=l2.next;
       }
       while(l1!=null){
           ListNode node=new ListNode();
           ans=l1.val+carry;
           carry=0;
           if(ans>=10){
               carry=1;
                ans=ans-10;
           }
           node.val=ans;
           temp.next=node;
           temp=temp.next;
           l1=l1.next;
       }
       while(l2!=null){
           ListNode node=new ListNode();
           ans=l2.val+carry;
           carry=0;
           if(ans>=10){
               carry=1;
                ans=ans-10;
           }
           node.val=ans;
           temp.next=node;
           temp=temp.next;
           l2=l2.next;
       }
       if(carry>0){
           ListNode node=new ListNode();
           node.val=carry;
           temp.next=node;
           temp=temp.next;
           carry=0;
       }
       result=result.next;
       result=getReverse(result);
       return result;
    }

    public ListNode getReverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode curr=head, prev=null,forward=head;
        while(curr!=null){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        return prev;
    }
}