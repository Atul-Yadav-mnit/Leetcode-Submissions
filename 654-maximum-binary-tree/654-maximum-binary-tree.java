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
    public TreeNode fun(int x, int y, int arr[])
    {
        if(x>y)
        {
            return null;
        }
        if(x==y)
        {
            return new TreeNode(arr[x]);
        }
        int max = arr[x];
        int maxi = x;
        for(int i=x;i<=y;i++)
        {
            if(max<arr[i])
            {
                max = arr[i];
                maxi = i;
            }
        }
        TreeNode ans = new TreeNode(max);
        ans.left = fun(x,maxi-1,arr);
        ans.right = fun(maxi+1,y,arr);
        return ans;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return fun(0,nums.length-1,nums);
    }
}