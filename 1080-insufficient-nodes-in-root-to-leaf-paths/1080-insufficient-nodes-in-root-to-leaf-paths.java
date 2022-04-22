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
    int limit;
    public ArrayList<Integer> fun(TreeNode root,int left, int cur)
    {
        if(root ==null)
        {
            return new ArrayList<Integer>();
        }
        
        
        cur = cur+root.val;
        ArrayList<Integer> l = fun(root.left,1,cur);
        ArrayList<Integer> r = fun(root.right,0,cur);
        
      //  System.out.println(root.val+" "+l+" "+r+" "+cur);
        
        
        boolean ans = true;
        for(int i=0;i<l.size();i++)
        {
            if(l.get(i)+cur>=limit)
            {
                ans= false;
            }
        }
        if(ans)
        {
            root.left = null;
          //  l = new ArrayList<Integer>();
        }
        
        
        
        
        ans = true;
        for(int i=0;i<r.size();i++)
        {
            if(r.get(i)+cur>=limit)
            {
                ans= false;
            }
        }
        if(ans)
        {
            root.right = null;
           // r = new ArrayList<Integer>();
        }
        
        
        
        
        
        
        
        l.addAll(r);
        if(l.size()==0)
        {
            l.add(0);
        }
        for(int i=0;i<l.size();i++)
        {
            l.set(i,l.get(i)+root.val);
        }
        
        
        return l;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null)
        {
            return null;
        }
        
        this.limit = limit;
        ArrayList<Integer>  l = fun(root,0,0);
        boolean ans = true;
        for(int i=0;i<l.size();i++)
        {
            if(l.get(i)>=limit)
            {
                ans= false;
            }
        }
        if(ans)
        {
            return null;
        }
        return root;
    }
}