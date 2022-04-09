// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            String s[] = new String[n];
            for(int i=0;i<n;i++)
            {
                s[i] = sc.next();
            }
            Solution T = new Solution();
            System.out.println(T.lcp(s,n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Node
{
    Node child[] = new Node[26];
    int count = 1;
}

class Solution
{
    public String lcp(String s[],int n)
    {
        int ans = s[0].length();
        // Write your code here
        Node root = new Node();
        int y =0;
        for(int i=0;i<s.length;i++)
        {
            Node temp = root;
            int j = 0;
            for(j=0;j<s[i].length();j++)
            {
                int x = s[i].charAt(j)-'a';
                if(temp.child[x] == null)
                {
                    temp.child[x] = new Node();
                    temp = temp.child[x];
                    if(temp.count == i+1)
                    {
                        
                    }
                    else
                    {
                        break;
                    }
                    
                }
                else
                {
                    temp = temp.child[x];
                    temp.count++;
                    if(temp.count == i+1)
                    {
                        
                    }
                    else
                    {
                        break;
                    }
                }
            }
            ans = Math.min(ans,j);
        }
        if(ans == 0)
        {
            return "-1";
        }
        return s[0].substring(0,ans);
        
        
    }
}
