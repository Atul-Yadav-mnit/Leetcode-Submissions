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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-9000);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur!=null)
        {
            prev.next = null;
            ListNode next = cur.next;
            cur.next = null;
            ListNode tcur = dummy.next;
            ListNode tprev = dummy;
            while(tcur!=null)
            {
                if(tcur.val > cur.val)
                {
                    ListNode temp = tprev.next;
                    tprev.next = cur;
                    cur.next = temp;
                    prev.next = next;
                    cur = next;
                    break;
                }
                else
                {
                    tprev = tcur;
                    tcur = tcur.next;
                }
            }
            if(tcur == null)
            {
                tprev.next = cur;
                cur.next = next;
                prev = cur;
                cur = cur.next;
            }
            
        }
        return dummy.next;
    }
}