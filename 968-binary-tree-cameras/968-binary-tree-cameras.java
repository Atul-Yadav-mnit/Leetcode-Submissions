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
      public  HashMap<String,Integer> h;
    public  int fun(TreeNode root, boolean doesparneed, boolean doesparhave)
    {
        if(root == null)
        {
            return 0;
        }
        String key = String.valueOf(root)+"_"+String.valueOf(doesparneed)+"_"+String.valueOf(doesparhave);
        int ans = 0;
        
        if(h.containsKey(key))
        {
       //     System.out.println("here");
            return h.get(key);
        }
        else if(doesparneed)
        {
            ans  = 1+fun(root.left,false,true)+fun(root.right,false,true);
        }
        else if(doesparhave)
        {
            int c1 = fun(root.left,false,false)+fun(root.right,false,false);
            int c2 = 1+fun(root.left,false,true)+fun(root.right,false,true);
            ans = Math.min(c1,c2);
        }
        else
        {
            int c1 = fun(root.left,true,false)+fun(root.right,false,false);
            int c2 = fun(root.left,false,false)+fun(root.right,true,false);
            int c3 = 1+fun(root.left,false,true)+fun(root.right,false,true);
            if(root.left == null)
            {
               c1 = Integer.MAX_VALUE;
            }
            if(root.right == null)
            {
               c2 = Integer.MAX_VALUE;
            }
            
            ans = Math.min(c1,Math.min(c2,c3));
        }
        h.put(key,ans);
        return ans;
    }
    public int minCameraCover(TreeNode root) {
        h = new HashMap<String,Integer>();
        return fun(root,false,false);
    }
}