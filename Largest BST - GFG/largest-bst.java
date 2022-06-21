// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Pair{
    int min,max,size;
    Pair(int min,int max, int size)
    {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

class Solution{
    static int ans;
    static Pair fun(Node root)
    {
        if(root.left == null && root.right == null)
        {
            ans = Math.max(ans,1);
            return new Pair(root.data,root.data,1);
        }
        else if(root.left == null)
        {
            Pair r = fun(root.right);
            if(root.data < r.min && r.size>=0)
            {
                ans = Math.max(ans,r.size+1);
                return new Pair(root.data,r.max,r.size+1);
            }
        }
        else if(root.right == null)
        {
            Pair l = fun(root.left);
            if(root.data > l.max && l.size>=0 )
            {
                ans = Math.max(ans,l.size+1);
                return new Pair(l.min,root.data,l.size+1);
            }
        }
        else
        {
            Pair l = fun(root.left);
            Pair r = fun(root.right);
            if(root.data > l.max && root.data < r.min && l.size>=0 && r.size>=0)
            {
                ans = Math.max(ans,l.size+r.size+1);
                return new Pair(l.min,r.max,l.size+r.size+1);
            }
        }
        return new Pair(0,1000001,-1000);
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        ans = 0;
        fun(root);
        return ans;
        
    }
    
}