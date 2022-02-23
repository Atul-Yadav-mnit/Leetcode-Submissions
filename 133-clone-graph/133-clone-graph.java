/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public HashMap<Integer,Node> h = new HashMap<Integer,Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }
        if(h.containsKey(node.val) == true)
        {
            return h.get(node.val);
        }
        else
        {
            Node n = new Node(node.val);
            h.put(n.val,n);
            for(int i=0;i<node.neighbors.size();i++)
            {
                Node temp = cloneGraph(node.neighbors.get(i));
                n.neighbors.add(temp);
            }
            return n;
        }
    }
}