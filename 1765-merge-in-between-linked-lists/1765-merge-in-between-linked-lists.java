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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode end2=list2;
        while(end2.next!=null){
            end2=end2.next;
        }

        ListNode curr1=list1, start1=list1;
        while(curr1.next!=null && a>1){
            curr1=curr1.next;
            a--;
        }

        start1=curr1;
        
        curr1=list1; // the part of list1 which we want to skip
        while(b>=0 && curr1.next!=null){
            curr1=curr1.next;
            b--;
        }

        start1.next=list2;
        end2.next=curr1;
        return list1;
    }
}