/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0;
        ListNode temp1 = headA;
        while(temp1!=null)
        {
            temp1 = temp1.next;
            n1++;
        }
        int n2 = 0;
        ListNode temp2 = headB;
        while(temp2!=null)
        {
            temp2 = temp2.next;
            n2++;
        }
        if(n1>=n2)
        {
            temp1 = headA;
            temp2 = headB;
            int diff = n1-n2;
            while(diff>0)
            {
                diff--;
                temp1 = temp1.next;
            }
            while(temp1!=null)
            {
                if(temp1 == temp2)
                {
                    return temp1;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        else
        {
            temp1 = headA;
            temp2 = headB;
            int diff = n2-n1;
            while(diff>0)
            {
                diff--;
                temp2 = temp2.next;
            }
            while(temp1!=null)
            {
                if(temp1 == temp2)
                {
                    return temp1;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }
}