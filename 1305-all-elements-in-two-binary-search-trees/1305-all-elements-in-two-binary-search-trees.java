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
    List<Integer> ans,ans1,ans2;
    void fun1(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        fun1(root.left);
        ans1.add(root.val);
        fun1(root.right);
    }
    void fun2(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        fun2(root.left);
        ans2.add(root.val);
        fun2(root.right);
    }
    void fun(int x, int y)
    {
        if(x==ans1.size())
        {
            while(y<ans2.size())
            {
                ans.add(ans2.get(y));
                y++;
            }
        }
        else if(y == ans2.size())
        {
            while(x<ans1.size())
            {
                ans.add(ans1.get(x));
                x++;
            }
        }
        else
        {
            if(ans1.get(x) <= ans2.get(y))
            {
                ans.add(ans1.get(x));
                fun(x+1,y);
            }
            else
            {
                ans.add(ans2.get(y));
                fun(x,y+1);
            }
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans = new ArrayList<Integer>();
        ans1 = new ArrayList<Integer>();
        ans2 = new ArrayList<Integer>();
        fun1(root1);
        fun2(root2);
        fun(0,0);
        return ans;
    }
}