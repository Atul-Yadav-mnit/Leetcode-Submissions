/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null )
        {
            return head;
        }
        HashMap<Node,Node> h = new HashMap<Node,Node>();
        Node ans = new Node(head.val);
        Node cur = ans;
        h.put(head,cur);
        Node temp = head.next;
        while(temp!=null)
        {
            cur.next = new Node(temp.val);
            cur= cur.next;
            h.put(temp,cur);
            temp = temp.next;
        }
        temp = head;
        cur = ans;
        while(temp!=null)
        {
            if(temp.random!=null)
            {
                 cur.random = h.get(temp.random);   
            }
            cur = cur.next;
            temp = temp.next;
        }
        return ans;
    }
}