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
    public int sum =0;
    public void fun(int x, TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        x = x*2+root.val;
        if(root.left==null &&  root.right==null)
        {
            sum+=x;
            return;
        }
        fun(x,root.left);
        fun(x,root.right);
    }
    public int sumRootToLeaf(TreeNode root) {
        fun(0,root);
        return sum;
    }
}