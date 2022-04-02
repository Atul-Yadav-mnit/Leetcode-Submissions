// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                }
                else{
                    Node temp=new Node(a);
                    temp.next=head;
                    head=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
    public Node moveZeroes(Node head){
        //Your Code here.
            Node hz = null;
            Node tz = null; 
            Node temp;
            Node nh = new Node(1);
            nh.next = head;
            head = nh;
            temp = head;
            while(temp.next!=null)
            {
                if(temp.next.data == 0)
                {
                    Node zn = temp.next;
                    temp.next = temp.next.next;
                    zn.next = null;
                    if(hz == null)
                    {
                        hz = zn;
                        tz = zn;
                    }
                    else
                    {
                        tz.next = zn;
                        tz = zn;
                    }
                }
                else
                {
                   temp = temp.next; 
                }
            }
            
            if(hz==null)
            {
                return head.next;
            }
            else
            {
                Node ans = hz;
                tz.next = head.next;
                return ans;
            }
        
    }
}