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
    public ListNode sortList(ListNode head) {
        if(head == null)
        {
            return head;
        }
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        while(head!=null)
        {
            ListNode temp= head;
            head = head.next;
            temp.next = null;
            arr.add(temp);
        }
        Collections.sort(arr,(c1,c2) -> c1.val-c2.val);
        head = arr.get(0);
        ListNode ans = head;
        for(int i=1;i<arr.size();i++)
        {
            head.next= arr.get(i);
            head = head.next;
        }
        return ans;
    }
}