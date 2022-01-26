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
    public int fun(TreeNode root, int p, int gp)
    {
        if(root == null)
        {
            return 0;
        }
        if(gp%2 == 0)
        {
            return root.val+fun(root.left,root.val,p)+fun(root.right,root.val,p);
        }
        else
        {
            return fun(root.left,root.val,p)+fun(root.right,root.val,p);
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        return fun(root,1,1);
    }
}