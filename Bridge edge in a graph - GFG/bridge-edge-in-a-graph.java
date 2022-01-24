// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        if(c == d)
        {
            return 0;
        }
        ArrayList<Integer> q = new ArrayList<Integer>();
        q.add(c);
        int vis[] = new int[V];
        vis[c] = 1;
        int cc = 0;
        while(q.size()>0)
        {
            int x = q.remove(0);
            
            for(int i=0;i<adj.get(x).size();i++)
            {
                int y = adj.get(x).get(i);
                if(x == c && y == d && cc == 0)
                {
                    cc = 1;
                    continue;
                }
                if(vis[y] == 0)
                {
                    vis[y] = 1;
                    q.add(y);
                    if(y == d)
                    {
                        return 0;
                    }
                }
            
            }
        }
        return 1; 
    }
}