// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class solver{
    
    static int sum,t,k;
    
    static int fun(Node root, int x)
    {
        if(root == null)
        {
            return -1;
        }
        
        if(root.data == t)
        {
            sum += root.data;
            fun(root.left,1);
            fun(root.right,1);
            return 1;
        }
        else if(x != -1)
        {
            if(x > k)
            {
                return -1;
            }
            else
            {
                sum+=root.data;
                fun(root.left,x+1);
                fun(root.right,x+1);
                return -1;
            }
        }
        else
        {
            int y = fun(root.left,-1);
            if(y!=-1)
            {
                if(y<=k)
                {
                    sum+=root.data;
                    fun(root.right,y+1);
                    return y+1;
                }
                else
                {
                    return -1;
                }
            }
           
            y = fun(root.right,-1);
            if(y!=-1)
            {
                if(y<=k)
                {
                    sum+=root.data;
                    fun(root.left,y+1);
                    return y+1;
                }
                else
                {
                    return -1;
                }
            }
            
            return -1;
            
            
        }
        
    }
    
    static int sum_at_distK(Node root, int target, int k){
        // code here
        sum = 0;
        t = target;
        solver.k = k;
        fun(root,-1);
        return sum;
    }
    
}

