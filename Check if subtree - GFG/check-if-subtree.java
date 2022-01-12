// { Driver Code Starts
//Initial Template for Java


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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String tt= br.readLine();
	            Node rootT = buildTree(tt);
	            
	            String s= br.readLine();
	            Node rootS = buildTree(s);
	           // printInorder(root);
	            
	            Solution tr=new Solution();
	            boolean st=tr.isSubtree(rootT, rootS);
	            if(st==true){
	                System.out.println("1");
	            }else{
	                System.out.println("0");
	            }
	        }
	}
}// } Driver Code Ends


//User function Template for Java

/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public static ArrayList<Integer> it,pt,is,ps;
    public static void itfun(Node x)
    {
        if(x == null)
        {
            it.add(4935);
            return ;
        }
        itfun(x.left);
        it.add(x.data);
        itfun(x.right);
    }
    
    public static void ptfun(Node x)
    {
        if(x == null)
        {
            pt.add(4935);
            return ;
        }
        pt.add(x.data);
        ptfun(x.left);
        ptfun(x.right);
    }
    
    public static void isfun(Node x)
    {
        if(x == null)
        {
            is.add(4935);
            return ;
        }
        isfun(x.left);
        is.add(x.data);
        isfun(x.right);
    }
    
    public static void psfun(Node x)
    {
        if(x == null)
        {
            ps.add(4935);
            return ;
        }
        ps.add(x.data);
        psfun(x.left);
        psfun(x.right);
    }
    
    
    
    public static boolean fun(ArrayList<Integer> p,ArrayList<Integer> s)
    {
        int np = p.size(), ns = s.size();
        int prefix[] = new int[np];
        int i = 1;
        int j = 0;
        while(i<np)
        {
           //System.out.print(i+" "+j+" "+p.get(i)+" "+p.get(j)+" "+ );
            if((int)p.get(i) == (int)p.get(j))
            {
                prefix[i] = j+1;
                i++;
                j++;
            }
            else
            {
                if(j == 0)
                {
                    i++;
                }
                else
                {
                    j = prefix[j-1];
                }
            }
        }
        // for(i=0;i<prefix.length;i++)
        // {
        //     System.out.print(prefix[i]+" ");
        // }
        // System.out.println();
        i = 0;
        j = 0;
        while(i<ns)
        {
            if((int)s.get(i) == (int)p.get(j))
            {
                i++;
                j++;
                if( j == np )
                {
                    return true;
                }
            }
            else
            {
                if(j == 0)
                {
                    i++;
                }
                else
                {
                    j = prefix[j-1];
                }
            }
        }
        return false;
    }
    
    // public static StringBuilder fun(Node x)
    // {
    //     StringBuilder s = new StringBuilder();
    //     if(x == null)
    //     {
    //         s.append("N");
    //     }
    //     else
    //     {
            
    //         s.append(fun(x.left));
    //         s.append("_"+x.data+"_");
    //         s.append(fun(x.right));
            
    //     }
    //     return s;
    // }
    
    //  public static StringBuilder funx(Node x)
    // {
    //     StringBuilder s = new StringBuilder();
    //     if(x == null)
    //     {
    //         s.append("N");
    //     }
    //     else
    //     {
    //          s.append("_"+x.data+"_");
    //         s.append(funx(x.left));
    //         s.append(funx(x.right));
            
    //     }
    //     return s;
    // }
 
    
    public static boolean isSubtree(Node T, Node S) {
        it = new ArrayList<Integer>();
        pt = new ArrayList<Integer>();
        is = new ArrayList<Integer>();
        ps = new ArrayList<Integer>();
        itfun(T);
        ptfun(T);
        isfun(S);
        psfun(S);
        // System.out.println(is);
        // System.out.println(it);
        // System.out.println(ps);
        // System.out.println(pt);
        // System.out.println(fun(is,it));
        // System.out.println(fun(ps,pt));
        return fun(is,it) && fun(ps,pt);
        
    }
}