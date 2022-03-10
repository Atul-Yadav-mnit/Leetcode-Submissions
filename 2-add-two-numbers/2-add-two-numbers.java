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
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ans  = null;
        ListNode t = null;
        int c = 0;
        while(t1!=null &&  t2!=null)
        {
            int a = t1.val;
            int b = t2.val;
            a = a+b+c;
            c = a/10;
            a = a%10;
            if(t == null)
            {
                t = t1;
                t.val = a;
                ans = t;   
                t1 = t1.next;
                t.next = null;
                t2 = t2.next;
            }
            else
            {
                t.next = t1;
                t = t.next;
                t.val = a;  
                t1 = t1.next;
                t.next = null;
                t2 = t2.next;
            }
        }
        while(t1!=null)
        {
            int a = t1.val;
            int b = 0;
            a = a+b+c;
            c = a/10;
            a = a%10;
            if(t == null)
            {
                t = t1;
                t.val = a;
                ans = t;   
                t1 = t1.next;
                t.next = null;
            }
            else
            {
                t.next = t1;
                t = t.next;
                t.val = a;  
                t1 = t1.next;
                t.next = null;
            }
        }
        t1 = t2;
        while(t1!=null)
        {
            int a = t1.val;
            int b = 0;
            a = a+b+c;
            c = a/10;
            a = a%10;
            if(t == null)
            {
                t = t1;
                t.val = a;
                ans = t;   
                t1 = t1.next;
                t.next = null;
            }
            else
            {
                t.next = t1;
                t = t.next;
                t.val = a;  
                t1 = t1.next;
                t.next = null;
            }
        }
        if(c!=0)
        {
            t.next = new ListNode(c);
        }
        return ans;
        
    }
}