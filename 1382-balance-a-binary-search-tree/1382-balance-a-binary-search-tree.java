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
    public TreeNode fun(ArrayList<TreeNode> arr, int l, int h)
    {
        if(l > h)
        {
            return null;
        }
        int m = l+(h-l)/2;
        TreeNode left = fun(arr,l,m-1);
        TreeNode right = fun(arr,m+1,h);
        TreeNode ans = arr.get(m);
        ans.left = left;
        ans.right = right;
        return ans;
    }
    ArrayList<TreeNode> arr;
    void fun2(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        TreeNode l = root.left,r = root.right;
        root.left = null;
        root.right = null;
        fun2(l);
        arr.add(root);
        fun2(r);
    }
    public TreeNode balanceBST(TreeNode root) {
        arr = new ArrayList<TreeNode>();
        fun2(root);
        return fun(arr,0,arr.size()-1);
    }
}