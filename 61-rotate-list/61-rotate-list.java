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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
        {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        ListNode end = null;
        while(temp!=null)
        {
            end = temp;
            temp = temp.next;
            count++;
        }
        k = k%count;
        if(k == 0)
        {
            return head;
        }
        k = count-k;
        
        temp = head;
        for(int i=1;i<k;i++)
        {
            temp = temp.next;
        }
       // System.out.println(end.val);
        ListNode temp2 = temp.next;
        temp.next = null;
        end.next = head;
        return temp2;
        
    }
}