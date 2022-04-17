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
    public int lvl = -1;
    public HashSet<Integer> arr = null;
    public void fun(TreeNode root,int l)
    {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            if(l > lvl)
            {
                arr = new HashSet<Integer>();
                arr.add(root.val);
                lvl = l;
            }
            else if(l == lvl)
            {
                arr.add(root.val);
            }
        }
        else
        {
            fun(root.left,l+1);
            fun(root.right,l+1);
        }
    }
    
    TreeNode ans = null;
    public int fun2(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int count = 0;
        int self = 0;
        if(arr.contains(root.val))
        {
            count++;
            self++;
        }
        int l = fun2(root.left);
        int r = fun2(root.right);
        if(self>0)
        {
            if(l+r+self == arr.size())
            {
                ans = root;
            }
        }
        else
        {
            if(l+r == arr.size() && l!=0 && r!=0)
            {
                ans = root;
            }
        }
        return l+r+self;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        fun(root,0);
        fun2(root);
        return ans;
    }
}