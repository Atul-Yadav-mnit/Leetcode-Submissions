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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] graph = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    graph[i][j] = Integer.parseInt(S[j]);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int u = Integer.parseInt(S1[0]);
            int v = Integer.parseInt(S1[1]);
            int k = Integer.parseInt(S1[2]);
            Solution ob = new Solution();
            int ans = ob.MinimumWalk(graph, u, v, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m = 1000000007;
    int t[][];
    public int fun(int g[][], int x, int d, int k)
    {
        if(k < 0)
        {
            return 0;
        }
        if(k == 0 && d==x)
        {
            return 1;
        }
        if(t[x][k] != -1)
        {
            return t[x][k];
        }
        int ans = 0;
        for(int i=0;i<g.length;i++)
        {
            if(g[x][i] == 1)
            {
                ans = (ans%m + fun(g,i,d,k-1)%m)%m;
            }
        }
        return t[x][k] = ans;
    }
    public int MinimumWalk(int[][] graph, int u, int v, int k)
    {
        // Code here
       
        t = new int[graph.length][k+1];
        for(int i=0;i<graph.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(graph,u,v,k);
    }
}