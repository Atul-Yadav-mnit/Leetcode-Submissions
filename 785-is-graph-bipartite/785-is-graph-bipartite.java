class Solution {
    public boolean isBipartite(int[][] adj) {
        int n = 0;
        for(int i=0;i<adj.length;i++)
        {
            for(int j=0;j<adj[i].length;j++)
            {
                n = Math.max(adj[i][j]+1,n);
            }
        }
        int vis[] =new int[n];
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
       
        for(int j=0;j<n;j++)
        {
            if(vis[j] == 0)
            {
                  arr.add(j);
                  vis[j] = 1;
                  while(arr.size()>0)
                  {
            int x =arr.remove(0);
            int yy = vis[x];
            if(yy == 1)
            {
                for(int i=0;i<adj[x].length;i++)
                {
                    int y = adj[x][i];
                    if(vis[y] == 0)
                    {
                        vis[y] = 2;
                        arr.add(y);
                    }
                    else if(vis[y] == 1)
                    {
                        return false;
                    }
                    else
                    {
                        
                    }
                }
            }
            else if(yy == 2)
            {
                for(int i=0;i<adj[x].length;i++)
                {
                    int y = adj[x][i];
                    if(vis[y] == 0)
                    {
                        vis[y] = 1;
                        arr.add(y);
                    }
                    else if(vis[y] == 1)
                    {

                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
            }
        }
      
        return true;
    }
}