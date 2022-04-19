// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        Node less = null;
        Node more = null;
        Node equal = null;
        Node temp = node,tl = null,te=null,tm = null;
        while(temp!=null)
        {
            Node y = temp;
            temp = temp.next;
            y.next = null;
            if(y.data == x)
            {
                if(te == null)
                {
                    equal = te = y;
                }
                else
                {
                    te.next = y;
                    te = y;
                }
            }
            else if(y.data > x)
            {
                if(tm == null)
                {
                    more = tm = y;
                }
                else
                {
                    tm.next = y;
                    tm = y;
                }
            }
            else
            {
                if(tl == null)
                {
                    less = tl = y;
                }
                else
                {
                    tl.next = y;
                    tl = y;
                }
            }
        }
        Node ans = less;
        if(tl == null)
        {
            ans = equal;
        }
        else
        {
            tl.next = equal;
        }
        if(te == null)
        {
            if(tl == null)
            {
                ans = more;
            }
            else
            {
                tl.next = more;
            }
        }
        else
        {
            te.next = more;
        }
        return ans;
    }
}