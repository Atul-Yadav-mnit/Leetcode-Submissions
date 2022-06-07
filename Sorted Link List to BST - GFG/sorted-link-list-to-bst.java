// { Driver Code Starts
import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class ListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    LNode temp;
    public TNode fun(int x)
    {
        if(x <= 0)
        {
            return null;
        }
        
        TNode t = new TNode(0);
        x--;
        t.left = fun((x+1)/2);
        t.right = fun(x/2);
        return t;
    }
    public void fun2(TNode t)
    {
        if(t == null)
        {
            return;
        }
        fun2(t.left);
        t.data = temp.data;
        temp = temp.next;
        fun2(t.right);
    }
    public TNode sortedListToBST(LNode head)
    {
        //code here+
        int n = 0;
        LNode temp = head;
        while(temp!=null)
        {
            temp = temp.next;
            n++;
        }
     //   System.out.println(n);
        this.temp = head;
        TNode h = fun(n);
        fun2(h);
        return h;
    }
}