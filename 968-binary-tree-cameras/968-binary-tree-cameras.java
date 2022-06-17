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
    HashMap<String,Integer> h;
    public int fun(TreeNode root, int ispar, int isme)
    {
        if(root == null)
        {
            return 0;
        }
        String key = String.valueOf(root)+" "+ispar+" "+isme;
        if(h.containsKey(key))
        {
            return h.get(key);
        }
        int ans = 0;
        if(ispar == 1)
        {
            if(isme == 1)
            {
                int a  = fun(root.left,1,0)+fun(root.right,1,0);
                int b  = 1 + fun(root.left,1,1)+fun(root.right,1,1);
                ans = Math.min(a,b);
            }
            else
            {
                int a  = 0;
                if(root.left == null && root.right == null)
                {
                    a = 1;
                }
                else if(root.left == null)
                {
                    a = fun(root.right,0,0);
                }
                else if(root.right == null)
                {
                    a = fun(root.left,0,0);
                }
                else
                {
                    int x = fun(root.right,1,0) + fun(root.left,0,0);
                    int y = fun(root.right,0,0) + fun(root.left,1,0);
                    a = Math.min(x,y);
                }
                int b  = 1 + fun(root.left,1,1)+fun(root.right,1,1);
                ans = Math.min(a,b);
            }
        }
        else
        {
            int a  = 1 + fun(root.left,1,1)+fun(root.right,1,1);
            ans = a;
        }
        h.put(key,ans);
        return ans;
    }
    public int minCameraCover(TreeNode root) {
        h = new HashMap<String,Integer>();
        return fun(root,1,0);
    }
}