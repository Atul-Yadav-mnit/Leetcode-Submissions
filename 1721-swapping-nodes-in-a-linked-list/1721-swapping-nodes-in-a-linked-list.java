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
        ListNode ttt = head;
        int n  =0;
        while(ttt!=null)
        {
            ttt = ttt.next;
            n++;
        }
        if(k>n)
        {
            return head;
        }
        // your code here
        int x1 = k;
        int x2 = n-k+1;
        
        if(x1==x2)
        {
            return head;
        }
        if(x1>x2)
        {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        int t = 1;
        ListNode prev = null;
        ListNode cur = head;
        while(t<x1)
        {
            t++;
            prev= cur;
            cur = cur.next;
        }
       
        ListNode n1 = cur;
        ListNode np1 = prev;
        ListNode nn1 = cur.next;
         prev = null;
        cur = head;
        t = 1;
        while(t<x2)
        {
            t++;
            prev= cur;
            cur = cur.next;
        }
        ListNode n2 = cur;
        ListNode np2 = prev;
        ListNode nn2 = cur.next;
       // System.out.println(n1.data+" "+n2.data+" "+x1+" "+x2);
        if(x1 == x2-1)
        {
           // System.out.println(n1+" "+n2);
            if(np1==null)
            {
                head = n2;
            }
            else
            {
                np1.next = n2;
            }
            n2.next = n1;
            n1.next = nn2;
            
            return head;
        }
        else
        {
            
            if(np1==null)
            {
                head = n2;
            }
            else
            {
                np1.next = n2;
            }
            n2.next = nn1;
            
            np2.next = n1;
            n1.next = nn2;
           
            return head;
        }
    }
}