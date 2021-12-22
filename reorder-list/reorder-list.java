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
    ListNode cur;
    boolean ans = false;
    public void fun(ListNode c)
    {
        if(c.next != null)
        {
            fun(c.next);
        }
        if(ans == true)
        {
            return;
        }
        if(c == cur || cur.next == c)
        {
            c.next = null;
            ans = true;
            return;
        }
        ListNode temp = cur.next;
        cur.next = c;
        c.next = temp;
        cur = temp;
    }
    public void reorderList(ListNode head) {
        cur = head;
        fun(head);
    }
}