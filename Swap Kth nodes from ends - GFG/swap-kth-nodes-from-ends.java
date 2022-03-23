// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class LinkedList
{
    static  Node head;  
    static  Node lastNode;
    
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();
            
            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }
            
            Node before[] = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();
            
            head = obj.swapkthnode(head, n, K);
        
           Node after[] = new Node[n];
          addressstore(after, head);
        
        if(check(before, after, n, K) == true)
            System.out.println("1");
        else
            System.out.println("0");
        
        }
    }
    
    static boolean check(Node before[], Node after[], int num, int K)
    {
          if(K > num)
           return true;
           
           return (before[K-1] == after[num - K]) && (before[num-K] == after[K-1]);
              
       
    }
    
    static void addressstore(Node arr[], Node head)
  {
      Node temp = head;
      int i = 0;
      while(temp != null){
        arr[i] = temp;
        i++;
        temp = temp.next;
    }
}
    
}// } Driver Code Ends


//User function Template for Java


/* Linked List Node class
   class Node  {
     int data;
     Node next;
     Node(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class GFG
{
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node head, int n, int k)
    {
        if(k>n)
        {
            return head;
        }
        // your code here
        int x1 = k;
        int x2 = n-k+1;
        
        if(x1==x2)
        {
            return head;
        }
        if(x1>x2)
        {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        int t = 1;
        Node prev = null;
        Node cur = head;
        while(t<x1)
        {
            t++;
            prev= cur;
            cur = cur.next;
        }
       
        Node n1 = cur;
        Node np1 = prev;
        Node nn1 = cur.next;
         prev = null;
        cur = head;
        t = 1;
        while(t<x2)
        {
            t++;
            prev= cur;
            cur = cur.next;
        }
        Node n2 = cur;
        Node np2 = prev;
        Node nn2 = cur.next;
       // System.out.println(n1.data+" "+n2.data+" "+x1+" "+x2);
        if(x1 == x2-1)
        {
           // System.out.println(n1+" "+n2);
            if(np1==null)
            {
                head = n2;
            }
            else
            {
                np1.next = n2;
            }
            n2.next = n1;
            n1.next = nn2;
            
            return head;
        }
        else
        {
            
            if(np1==null)
            {
                head = n2;
            }
            else
            {
                np1.next = n2;
            }
            n2.next = nn1;
            
            np2.next = n1;
            n1.next = nn2;
           
            return head;
        }
        
    }
}
