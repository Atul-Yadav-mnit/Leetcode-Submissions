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
    Node lft,plft;
    int lvl;
    public void fun(Node root,Node par, int l)
    {
        if(root == null || par == null || root.val>10000)
        {
             return;
        }
       // System.out.println(root.val+" "+par.val);
        if(plft == null)
        {
            if(root.left!=null)
            {
                plft = root;
                lft = root.left;
               // System.out.println(plft.val+" "+lft.val);
            }
            else if(root.right!=null)
            {
                plft = root;
                lft = root.right;
               // System.out.println(plft.val+" "+lft.val);
            }
            
        }
        
        //System.out.println(root.val+" "+par.val);
        if(par.left == root  )
        {
            
           // System.out.println(root.val+" 1  -> "+par.right.val);
            if(par.right != null)
            {
                root.next = par.right;
                fun(root.next,par,l);
            }
            else
            {
                fun(root,par.next,l);
            }
            
        }
        else if(par.right == root)
        {
            fun(root,par.next,l);
        }
        else if(par.left != null)
        {
           // System.out.println(root.val+" 2 -> "+par.left.val);
            root.next = par.left;
            fun(root.next,par,l);
        }
        else if(par.right!=null)
        {
           // System.out.println(root.val+" 3 -> "+par.right.val);
            root.next = par.right;
            fun(root.next,par,l);
        }
        else
        {
            fun(root,par.next,l);
        }
       // if(root.next == null)
        //System.out.println(root.val+" -> null");
        if(root == plft)
        {
            
           // System.out.println("Here"+lft.val+" "+plft.val+" "+lvl);
            Node tlft = lft; 
            Node tplft = plft;
            lft = null;
            plft = null;
            fun(tlft,tplft,lvl);
        }
        
        
    }
    public Node connect(Node root) {
        if(root == null)
        {
            return root;
        }
        fun(root.left,root,1);
        if(root.left == null)
        {
            fun(root.right,root,1);
        }
        
        
        return root;
    }
}