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
class BSTIterator {

    public ArrayList<TreeNode> arr;
    public void fun(TreeNode root)
    {
        if(root == null)
        {
            return ;
        }
        fun(root.left);
        arr.add(root);
        fun(root.right);
    }
    int x = 0;
    public BSTIterator(TreeNode root) {
        arr = new ArrayList<TreeNode>();
        fun(root);
        x = 0;
    }
    
    public int next() {
        x++;
        return arr.get(x-1).val;
    }
    
    public boolean hasNext() {
        return x!=arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */