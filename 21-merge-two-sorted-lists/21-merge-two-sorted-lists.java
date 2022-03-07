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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null,temp = null;
        int i = 0;
        while(list1!=null && list2!=null )
        {
            ListNode a = list1;
            ListNode b = list2;
            // list1 = list1.next;
            // list2 = list2.next;
            // a.next = null;
            // b.next = null;
            if(a.val <= b.val)
            {
                if(head == null)
                {
                    temp = a;
                    head = temp;
                    list1 = temp.next;
                    temp.next = null;
                   
                }
                else
                {
                    temp.next = a;
                    list1 = a.next;
                    temp = temp.next;
                    temp.next = null;
                }
            }
            else
            {
                if(head == null)
                {
                    temp = b;
                    head = temp;
                    list2 = temp.next;
                    temp.next = null;
                    
                }
                else
                {
                    temp.next = b;
                    list2 = b.next;
                    temp = temp.next;
                    temp.next = null;
                }
            }

        }
        if(list1!=null)
        {
            if(head == null)
            {
                return list1;
            }
            temp.next = list1;
        }
        if(list2!=null)
        {
            if(head == null)
            {
                return list2;
            }
            temp.next = list2;
        }
        return head;
    }
}