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
    List<List<Integer>> ans;
    int x = 0;
    public int lvl(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1+Math.max(lvl(root.left),lvl(root.right));
    }
    public void fun(TreeNode root, int lvl)
    {
        if(root == null)
        {
            return ;
        }
        fun(root.left,lvl+1);
        int y = (x-lvl+x-1)%x;
        ans.get(y).add(root.val);
        fun(root.right,lvl+1);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ans = new ArrayList<List<Integer>>();
        x = lvl(root);
        for(int i=0;i<x;i++)
        {
            ans.add(new ArrayList<Integer>());
        }
        fun(root,0);
        return ans;
    }
}