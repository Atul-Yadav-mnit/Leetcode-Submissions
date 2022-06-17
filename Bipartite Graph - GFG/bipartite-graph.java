// { Driver Code Starts
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
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int vis[] = new int[V];
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(vis[i] == 0)
            {
                vis[i] = 1;
                a.add(i);
                while(a.size()>0)
                {
                    int x = a.remove(0);
                    for(int j=0;j<adj.get(x).size();j++)
                    {
                        int y = adj.get(x).get(j);
                        if(vis[y] == 0)
                        {
                            if(vis[x] == 1)
                            {
                                vis[y] = 2;
                            }
                            else
                            {
                                vis[y] = 1;
                            }
                            a.add(y);
                        }
                        else if(vis[y] == vis[x])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}