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
    int k = 0,f,ans;
    public void fun(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        fun(root.left);
        k++;
        if(k == f)
        {
            ans = root.val;
        }
        fun(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = 0;
        f = k;
        fun(root);
        return ans;
    }
}