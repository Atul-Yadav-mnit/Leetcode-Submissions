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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((p1,p2) -> p1.val-p2.val);
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            pq.add(lists[i]);
        }
        ListNode ans = null;
        ListNode ansl = null;
        while(pq.size()>0)
        {
            ListNode cur = pq.poll();
            if(cur.next!=null)
            {
                pq.add(cur.next);
            }
            cur.next = null;
            if(ans == null)
            {
                ans = cur;
                ansl = cur;
            }
            else
            {
                ansl.next = cur;
                ansl = ansl.next;
            }
        }
        return ans;
    }
}