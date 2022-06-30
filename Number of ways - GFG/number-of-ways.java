// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            System.out.println(ob.arrangeTiles(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static long t[];
    static long fun(int N)
    {
        if(N==0)
        {
            return 1L;
        }
        if(t[N]!=-1)
        {
            return t[N];
        }
        if(N>=4)
        {
            return  t[N] = fun(N-4)+fun(N-1);
        }
        return t[N] = fun(N-1);
    }
    static long arrangeTiles(int N){
        // code here
        t = new long[N+1];
        Arrays.fill(t,-1L);
        return fun(N);
    }
}