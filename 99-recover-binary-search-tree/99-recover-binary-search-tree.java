/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Prev{
        TreeNode prev,prevpar;
        Prev(TreeNode prev, TreeNode prevpar)
        {
            this.prev = prev;
            this.prevpar = prevpar;
        }
    }
    public TreeNode c1 = null,p1 = null,c2 = null,p2 = null;
    public Prev a = null;
    public void fun(TreeNode root, TreeNode par)
    {
        if(root == null)
        {
            return ;
        }
        fun(root.left,root);
        if(a!=null)
        {
            System.out.println(root.val+" "+a.prev.val);
            if(a.prev.val > root.val)
            {
                if(c1 == null)
                {
                    c1 = a.prev;
                    p1 = a.prevpar;
                    c2 = root;
                    p2 = par;
                }
                else
                {
                    c2 = root;
                    p2 = par; 
                }
            }
        }
        a = new Prev(root,par);
       fun(root.right,root);
        
    }
    public void recoverTree(TreeNode root) {
        fun(root,null);
     //   System.out.println(c1.val+" "+p1+" "+c2.val+" "+p2.val);
        int temp = c1.val;
        c1.val = c2.val;
        c2.val = temp;
        
    }
}