/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         if(root == null)
        {
            return null;
        }
        ArrayList<Node> a = new ArrayList<Node>();
        ArrayList<Integer> lvl = new ArrayList<Integer>();
        
        ArrayList<Node> q = new ArrayList<Node>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        q.add(root);
        l.add(0);
        while(q.size()>0)
        {
            Node x = q.remove(0);
            int y = l.remove(0);
            a.add(x);
            lvl.add(y);
            if(x.left!=null)
            {
                q.add(x.left);
                l.add(y+1);
            }
            if(x.right!=null)
            {
                q.add(x.right);
                l.add(y+1); 
            }
        }
        for(int i=0;i<a.size()-1;i++)
        {
            if(lvl.get(i) == lvl.get(i+1))
            {
                a.get(i).next = a.get(i+1);
            }
        }
        return root;
    }
}