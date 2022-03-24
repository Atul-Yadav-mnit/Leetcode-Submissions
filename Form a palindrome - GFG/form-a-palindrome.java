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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int t[][];
    int fun(String s, int x, int y)
    {
        if(x >= y)
        {
            return 0;
        }
        if(t[x][y]!=-1)
        {
            return t[x][y];
        }
        if(s.charAt(x) == s.charAt(y))
        {
            return t[x][y]= fun(s,x+1,y-1);
        }
        else
        {
            return t[x][y] = 1+Math.min(fun(s,x+1,y),fun(s,x,y-1));
        }
    }
    int findMinInsertions(String S){
        // code here
        int n = S.length();
        t = new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(t[i],-1);
        return fun(S,0,n-1);
    }
}