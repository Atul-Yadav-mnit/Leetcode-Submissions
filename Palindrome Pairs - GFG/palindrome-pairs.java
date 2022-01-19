// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = new String[N];
            
            for(int i=0; i<N; i++)
                arr[i] = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.palindromepair(N,arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Node{
        Node c[] = new Node[26];
        boolean end = false;
    }
    
    
class Solution {
    static int palindromepair(int N, String arr[]) {
        // code here
        Arrays.sort(arr,(a1,a2) -> a1.length()-a2.length());
        Node head = new Node();
        Node temp = head;
        boolean found = true;
        for(int i=0;i<arr.length;i++)
        {
            String s = arr[i];
            int n = s.length();
            for(int l=n+1;l<=n*2;l++)
            {
                int x = l-n;
                found = true;
                for(int j=x;j<n;j++)
                {
                    if(s.charAt(j) != s.charAt(n-1-(j-x)) )
                    {
                        found = false;
                        break;
                    }
                }
                if(found == true)
                {
                    temp = head;
                    for(int j=0;j<x;j++)
                    {
                        if(temp.c[s.charAt(j)-'a'] != null)
                        {
                            temp = temp.c[s.charAt(j)-'a'];
                        }
                        else
                        {
                            found = false;
                            break;
                        }
                    }
                }
                if(found == true && temp.end)
                {
                    return 1;
                }
                
                
                
                
                found = true;
                 for(int j=0;j<n-x;j++)
                {
                    if(s.charAt(j) != s.charAt(n-x-1-j) )
                    {
                        found = false;
                        break;
                    }
                }
                if(found == true)
                {
                    temp = head;
                    for(int j=n-x;j<n;j++)
                    {
                        if(temp.c[s.charAt(j)-'a'] != null)
                        {
                            temp = temp.c[s.charAt(j)-'a'];
                        }
                        else
                        {
                            found = false;
                            break;
                        }
                    }
                }
                if(found == true && temp.end)
                {
                    return 1;
                }
                
                
                
                
            }
            temp = head;
            for(int j=arr[i].length()-1;j>=0;j--)
            {
                int x = arr[i].charAt(j)-'a';
                if(temp.c[x] == null)
                {
                    temp.c[x] = new Node();
                }
                temp = temp.c[x];
            }
            temp.end = true;
        }
        
        return 0;
    }
};