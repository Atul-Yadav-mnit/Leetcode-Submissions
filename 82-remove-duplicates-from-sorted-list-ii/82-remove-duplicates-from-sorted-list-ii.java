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
        ListNode temp = head,prev = null;
        boolean isf = false;
        while(temp!=null)
        {
            if(temp.next == null)
            {
                if(isf)
                {
                    if(prev == null)
                    {
                        head = temp.next;
                        temp = head;
                        prev = null;
                    }
                    else
                    {
                        prev.next = temp.next;
                        temp = temp.next;
                    }
                    isf = false;
                }
                else
                {
                   prev = temp;
                   temp = temp.next;
                }
            }
            else if(temp.val != temp.next.val)
            {
                if(isf)
                {
                    if(prev == null)
                    {
                        head = temp.next;
                        temp = head;
                        prev = null;
                    }
                    else
                    {
                        prev.next = temp.next;
                        temp = temp.next;
                    }
                    isf = false;
                }
                else
                {
                   prev = temp;
                   temp = temp.next;
                }
            }
            else
            {
                isf = true;
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}