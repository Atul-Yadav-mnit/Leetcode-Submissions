// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Node
{
    Node c[] = new Node[26];
}

class Solution{
    Node head = new Node();
    String longestCommonPrefix(String arr[], int n){
        // code here
        Node cur = head;
        for(int j=0;j<arr[0].length();j++)
        {
            // arr[i][j];
            cur.c[ arr[0].charAt(j)-'a' ] = new Node();
            cur = cur.c[ arr[0].charAt(j)-'a' ];
        }
        int min = arr[0].length();
        
        for(int i=1;i<arr.length;i++)
        {
            cur = head;
            int x = arr[i].length();
            for(int j=0;j<arr[i].length();j++)
            {
                // arr[i][j];
                if( cur.c[ arr[i].charAt(j)-'a' ] == null )
                {
                    x = j;
                    break;
                }
                cur = cur.c[ arr[i].charAt(j)-'a' ];
            }
            if(x < min)
            {
                min = x;
            }
        }
        if(min == 0)
        {
            return "-1";
        }
        return arr[0].substring(0,min);
    }
}