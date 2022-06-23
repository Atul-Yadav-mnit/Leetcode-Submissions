// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long m = 1000000007;
    long t[][];
    public long fun(int N,int x, int prev)
    {
        if(x > N)
        {
            return 1;
        }
        if(t[x][prev]!=-1)
        {
            return t[x][prev];
        }
        if(prev ==0)
        {
            return t[x][prev] = (fun(N,x+1,1)%m + fun(N,x+1,0)%m)%m;
        }
        return t[x][prev] = fun(N,x+1,0)%m;
    }
    public int TotalWays(int N)
    {
        // Code here
        t = new long[N+1][2];
        for(int i=0;i<=N;i++)
        {
            Arrays.fill(t[i],-1);
        }
        long x = fun(N,1,0);
        return (int)((x%m *x%m)%m);
    }
}