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
    
    public boolean fun(TreeNode root, int target)
    {
        boolean ans1 = true, ans2=true;
        if(root.left!=null)
        {
            ans1 = fun(root.left,target);
            if(ans1 == true)
            {
                root.left = null;
            }
        }
        
        if(root.right!=null)
        {
            ans2 = fun(root.right,target);
            if(ans2 == true)
            {
                root.right = null;
            }
        }
        return (root.val == target) && ans1 && ans2;
        
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(fun(root,target) == true)
        {
            return null;
        }
        return root;
    }
}