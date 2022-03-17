// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N,K);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public int N;
    long m = 1000000007L,t[][];
    public long fun(int x,int used, int K)
    {
        if(x == N)
        {
            return 1;
        }
        if(t[x][used] != -1)
        {
            return t[x][used];
        }
        if(K-used>0)
        {
            return t[x][used] = ((21*(fun(x+1,0,K)%m))%m + (5*(fun(x+1,used+1,K)%m))%m )%m;
        }
        else
        {
            return t[x][used] = (21*fun(x+1,0,K)%m)%m;
        }
    }
    public int kvowelwords(int N,int K){
        // code here
        t = new long[N+1][K+1];
        for(int i=0;i<N+1;i++)
        {
            Arrays.fill(t[i],-1);
        }
        this.N = N;
        return (int)fun(0,0,K);
    }
}
