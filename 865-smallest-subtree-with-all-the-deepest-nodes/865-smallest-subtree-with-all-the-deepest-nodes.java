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
    public HashSet<Integer> arr;
    int ans = -1;
    TreeNode ans2 = null;
    public void fun(TreeNode root, int depth)
    {
        if(root == null)
        {
            return ;
        }
      //  System.out.println(root.val+" "+depth);
        if(root.left ==null && root.right == null)
        {
            if(depth > ans)
            {
                arr = new HashSet<Integer>();
                arr.add(root.val);
                ans = depth;
            }
            else if(depth == ans)
            {
                arr.add(root.val);
            }
            return;
        }
        fun(root.left,depth+1);
        fun(root.right,depth+1);
    }
    public int fun2(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int count = 0;
        if(arr.contains(root.val))
        {
            count++;
        }
        int l = fun2(root.left);
        int r = fun2(root.right);
        
        if(ans2 == null && count+l+r==arr.size())
        {
            ans2 = root;
        }
    
        return count+l+r;
        
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        fun(root,0);
        System.out.println(arr);
        fun2(root);
        return ans2;
    }
}