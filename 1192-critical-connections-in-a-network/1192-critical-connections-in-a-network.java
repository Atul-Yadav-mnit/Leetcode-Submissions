class Solution {
    List<List<Integer>> ans;
    List<List<Integer>> adj;
    int vis[];
    public HashSet<Integer> fun(int x, int par)
    {
        HashSet<Integer> h = new HashSet<Integer>();
        vis[x] = 2;
        for(int i=0;i<adj.get(x).size();i++)
        {
            int y = adj.get(x).get(i);
            if(y == par)
            {
                continue;
            }
            if(vis[y] == 0)
            {
                HashSet<Integer> h2 = fun(y,x);
                h.addAll(h2);
                
            }
            else if(vis[y] == 2)
            {
                h.add(y);
            }
        }
        vis[x] = 1;
        
        if(h.contains(x))
        {
            h.remove(x);
        }
        if(h.size() == 0 && par!=-1)
        {
            List<Integer> t = new ArrayList<Integer>();
            t.add(x);
            t.add(par);
            ans.add(t);
        }
        //System.out.println(h+" "+x+" "+par);
        return h;
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> c) {
        ans = new ArrayList<List<Integer>>();
        adj = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<c.size();i++)
        {
            int x = c.get(i).get(0);
            int y = c.get(i).get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        vis = new int[n];
        fun(0,-1);
        return ans;
    }
}