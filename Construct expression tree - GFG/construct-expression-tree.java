// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    char val;
    Node left, right;
    Node(char c)
    {
        val = c;
        left = right = null;
    }
}

class Construct
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            char postfix[] = str.toCharArray();
            GfG gfg = new GfG();
            Node et = gfg.constructTree(postfix);
            inorder(et);
            System.out.println();
        }
    }
    
    public static void inorder(Node et)
    {
        if(et != null)
        {
            inorder(et.left);
            System.out.print(et.val + " ");
            inorder(et.right);
        }
    }
    
    public static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
          return true;
          
        return false;
    }
}

// } Driver Code Ends


class GfG
{
    
    public static Node constructTree(char p[])
    {
        Stack<Node> s = new Stack<Node>();
        for(int i=0;i<p.length;i++)
        {
            char c = p[i];
            if(c >='a' && c<='z')
            {
                s.push(new Node(c));
            }
            else
            {
                Node x = new Node(c);
                x.right = s.pop();
                x.left = s.pop();
                s.push(x);
            }
        }
        return s.pop();
    }
    
}