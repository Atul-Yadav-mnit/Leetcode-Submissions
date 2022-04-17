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
    TreeNode cur = null,ans = null;
    public void fun(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        fun(root.left);
        TreeNode temp = root.right;
        root.right = root.left = null;
        if(cur == null)
        {
            ans = root;
            cur = root;
        }
        else
        {
            cur.right = root;
            cur = cur.right;
        }
        fun(temp);
    }
    public TreeNode increasingBST(TreeNode root) {
        fun(root);
        return ans;
    }
}