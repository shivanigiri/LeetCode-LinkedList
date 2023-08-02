/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //swap the value of node to next node valuethen delete next node.
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
//swap the value of node one by one. and push node.val to last then unlink last node.
    //    /*node =5 head=[4,5,1,9]
    //    we have 5-1-9-null
    //     1-5-9-null
    //     1-9-5-null  
    //     1-9-null
    //    */
    //    ListNode curr=node,prev=curr;
    //    while(curr.next!=null){
    //        int temp=curr.val;
    //        curr.val=curr.next.val;
    //        curr.next.val=temp;
    //        prev=curr;
    //        curr=curr.next;
    //    }
    //    prev.next=null;