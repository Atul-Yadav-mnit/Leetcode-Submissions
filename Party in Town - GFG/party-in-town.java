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
            int N = Integer.parseInt(in.readLine());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    		for(int i = 0;i < N+1;i++){
    	        ArrayList<Integer> arr = new ArrayList<Integer>();
    	        adj.add(arr);
    		}
    		for(int i = 0;i < N-1;i++){
    		    String a[] = in.readLine().trim().split("\\s+");
    		    int x = Integer.parseInt(a[0]);
    		    int y = Integer.parseInt(a[1]);
    		    adj.get(x).add(y);
    		    adj.get(y).add(x);
    		}
    		
    		Solution ob = new Solution();
    		System.out.println(ob.partyHouse(N, adj));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int fun(int x,int N, ArrayList<ArrayList<Integer>> adj, int vis[])
    {
        int max = 0;
        for(int i=0;i<adj.get(x).size();i++)
        {
            if(vis[adj.get(x).get(i)] == 0)
            {
                vis[adj.get(x).get(i)] = 1;
                max = Math.max(max,1+fun(adj.get(x).get(i),N,adj,vis));
            }
        }
        return max;
    }
    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int min = Integer.MAX_VALUE;
        int mini = -1;
        for(int i =1;i<=N;i++)
        {
            int vis[] = new int[N+1];
            vis[i] = 1;
            int x = fun(i,N,adj,vis);
            if(x < min)
            {
                min = x;
                mini = i;
            }
        }
        return min;
    }
}