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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        boolean flag=false;
        ListNode prev=null, curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                flag=true;
            }else{
                //when recurring number is there in middle.(1,2,3,3,4,4,5)
                if(flag && prev!=null){
                    prev.next=curr.next;
                }
                //when recurring number is there in beginning.(1,1,2,2,3,5)
                else if(flag && prev==null){
                    head=curr.next;
                }
                //when distinct(1,2,3,3,4)
                else{
                    prev=curr;
                }
                flag=false;
            }
            curr=curr.next;
        }
        
        if(flag){
            if(prev==null){//when only recurring number is there in end(1,1,4,4)
                return null;
            }
            else{ ////when recurring number is there in end.(1,2,3,3,4,4)
                prev.next=null;
            }
        }
        return head;
    }
}