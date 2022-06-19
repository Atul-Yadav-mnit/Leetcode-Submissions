// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node reverse(Node cur)
    {
        Node head = cur;
        cur = cur.next;
        head.next = null;
        while(cur!=null)
        {
            Node t = cur;
            cur = cur.next;
            t.next = head;
            head = t;
        }
        return head;
    }
    public static Node reverseBetween(Node head, int m, int n)
    {
        //code here
        if(m >= n)
        {
            return head;
        }
        Node n1=head,n2=null,n3=null;
        if(m == 1)
        {
            n1 = null;
        }
        Node cur = head;
        for(int i=1;i<=n;i++)
        {
            if(i == m-1)
            {
                n1 = cur;
            }
            if(i == m)
            {
                n2 = cur;
            }
            if(i == n)
            {
                n3 = cur.next;
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
        n2 = reverse(n2);
        if(n1 == null)
        {
            head = n2;
        }
        else
        {
            n1.next = n2;
        }
        while(n2.next!=null)
        {
            n2 = n2.next;
        }
        n2.next = n3;
        return head;
    }
}