/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans;
    int k,t;
    public int fun(TreeNode root, int cur)
    {
        if(root == null)
        {
            return -1;
        }
        if(root.val == t)
        {
            if(k == 0)
            ans.add(root.val);
            fun(root.left,k-1);
            fun(root.right,k-1);
            return k-1;
        }
        if(cur>=0)
        {
            if(cur == 0)
            ans.add(root.val);
            fun(root.left,cur-1);
            fun(root.right,cur-1);
            return -1;
        }
        int a = fun(root.left,-1);
        if(a>=0)
        {
            if(a == 0)
            ans.add(root.val);
            fun(root.right,a-1);
            return a-1;
        }
        else
        {
            a = fun(root.right,-1);
            if(a>=0)
            {
                if(a == 0)
                ans.add(root.val);
                fun(root.left,a-1);
                return a-1;
            }
            else
            {
                return -1;
            }
        }
    
      
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<Integer>();
        this.k = k;
        this.t = target.val;
        fun(root,-1);
        return ans;
    }
}