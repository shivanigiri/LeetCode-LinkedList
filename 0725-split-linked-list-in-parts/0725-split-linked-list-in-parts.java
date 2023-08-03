class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode curr = head;
        int length = 0;
        while(curr!=null){
            curr = curr.next;
            length++;
        }
        int rem =0;
          if(length>=k){ // if condition to handle edge cases
          rem =  length %k;
          }
        
        int cutLength =  length/k;// find the length of subparts we need to divide it into 
        
        curr = head;
        ListNode arr[] = new ListNode[k];
        ListNode temp = curr;
        int len =0,x =0;
        while(curr!=null )
        {
            len = rem>0 
                ? cutLength + 1
                : cutLength;
// remember to decrement rem as we are using 1 from rem always for each     subarray length 
            rem = rem-1;
            // reach till the end 
            while(curr.next!= null && (len--)>1){
                curr =  curr.next;
            }
           
            // save the new head
            ListNode newHead =  curr.next;
            curr.next = null;
            // store the curr subarray to the result
            arr[x] = temp;
            // move to the next subarray 
            temp =  newHead;
            curr = newHead;
            x++;
        }
        return arr;
    }
}