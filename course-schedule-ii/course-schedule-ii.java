class Solution {
    public int vis[];
    public boolean iscyclic = false;
    Stack<Integer> s;
    public void fun(ArrayList<ArrayList<Integer>> adj, int v, int x)
    {
        if(iscyclic == true)
        {
            return;
        }
        for(int i=0;i<adj.get(x).size();i++)
        {
            if(vis[adj.get(x).get(i)] == 0)
            {
                vis[adj.get(x).get(i)] = 2;
                fun(adj,v,adj.get(x).get(i));
                s.push(adj.get(x).get(i));
                vis[adj.get(x).get(i)] = 1;
            }
            else if(vis[adj.get(x).get(i)] == 2)
            {
                iscyclic = true;
                return;
            }
        }
    }
    
    public int[] findOrder(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<p.length;i++)
        {
            adj.get(p[i][1]).add(p[i][0]);
        }
        vis = new int[n];
        // vis = 0 if unvis 1 for vis 2 foractive
        s = new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            if(iscyclic == true)
            {
                break;
            }
            if(vis[i] == 0 )
            {
                vis[i] = 2;
                fun(adj,n,i);
            //    System.out.println(s+" "+i);
                s.push(i);
                vis[i] = 1;
            }
        }
        //System.out.println(s);
        if(iscyclic)
        {
            int ans[] = new int[0];
            return ans;
        }
        else
        {
            int ans[] = new int[n];
            int i=0;
            while(s.isEmpty() == false)
            {
                ans[i++] = s.pop();
            }
            return ans;
        }
    }
}
    
