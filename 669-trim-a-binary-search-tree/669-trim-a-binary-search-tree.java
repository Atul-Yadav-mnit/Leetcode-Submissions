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
    TreeNode root;
    int low,high;
    public void fun(TreeNode par, TreeNode cur)
    {
        if(cur == null)
        {
            return;
        }
        if(cur.val < low)
        {
            if(par!=null)
            {
                if(par.val > cur.val)
                {
                    //left chld
                    par.left = cur.right;
                    cur = par.left;
                }
                else
                {
                    // right chld    
                    par.right = cur.right;
                    cur = par.right;
                }
                fun(par,cur);
            }
            else
            {
                root = cur.right;
                fun(par,root);
            }
        }
        else if(cur.val > high)
        {
            if(par!=null)
            {
                if(par.val > cur.val)
                {
                    //left chld
                    par.left = cur.left;
                    cur = par.left;
                }
                else
                {
                    // right chld    
                    par.right = cur.left;
                    cur = par.right;
                }
                fun(par,cur);
            }
            else
            {
                root = cur.left;
                fun(par,root);
            }
        }
        else
        {
            fun(cur,cur.left);
            fun(cur,cur.right);
        }
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.root = root;
        this.low = low;
        this.high = high;
        fun(null,root);
        return this.root;
    }
}