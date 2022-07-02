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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<ArrayList<Integer>> adj;
    int t[];
    public int fun(int x, int d, int vis[])
    {
        if(x == d)
        {
            return t[x] = 1;
        }
        int ans = 0;
        if(t[x]!=-1)
        {
            return t[x];
        }
        for(int i=0;i<adj.get(x).size();i++)
        {
            int y = adj.get(x).get(i);
            if(vis[y] == 0)
            {
                vis[y] = 1;
                ans += fun(y,d,vis);
            }
            else
            {
                ans += t[y];
            }
        }
        return t[x] = ans;
    }
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0 ;i<n ;i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            adj.add(temp);
        }
        for(int i=0 ;i<edges.length ;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int vis[] = new int[n];
        t = new int[n];
        Arrays.fill(t,-1);
        return fun(s,d,vis);
    }
}