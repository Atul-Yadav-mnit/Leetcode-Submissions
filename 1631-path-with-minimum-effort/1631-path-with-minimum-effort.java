class Solution {
    class Pair{
        int x,y,v;
        Pair(int x, int y, int v)
        {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    public int minimumEffortPath(int[][] h) {
        int r = h.length;
        int c = h[0].length;
        int vis[][] = new int[r][c];
        int cost[][] = new int[r][c];
        for(int i=0;i<r;i++)
        Arrays.fill(cost[i],1000000);
        cost[0][0] = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1,p2) -> p1.v-p2.v);
        pq.add(new Pair(0,0,0));
        while(vis[r-1][c-1]==0)
        {
            Pair p = pq.remove();
            int a = p.x;
            int b = p.y;
            
            vis[a][b] = 1;
            
            if(a+1<r && vis[a+1][b] == 0&& Math.max( cost[a][b], Math.abs(h[a+1][b] - h[a][b]) ) < cost[a+1][b] )
            {
                cost[a+1][b] = Math.max( cost[a][b], Math.abs(h[a+1][b] - h[a][b]) );
                pq.add(new Pair(a+1,b,cost[a+1][b]));
            }
            if(b+1<c && vis[a][b+1] == 0&& Math.max( cost[a][b], Math.abs(h[a][b+1] - h[a][b]) ) < cost[a][b+1] )
            {
                cost[a][b+1] = Math.max( cost[a][b], Math.abs(h[a][b+1] - h[a][b]) );
                 pq.add(new Pair(a,b+1,cost[a][b+1]));
            }
            if(a-1>=0 && vis[a-1][b] == 0&& Math.max( cost[a][b], Math.abs(h[a-1][b] - h[a][b]) ) < cost[a-1][b] )
            {
                cost[a-1][b] = Math.max( cost[a][b], Math.abs(h[a-1][b] - h[a][b]) );
                 pq.add(new Pair(a-1,b,cost[a-1][b]));
            }
            if(b-1>=0 && vis[a][b-1] == 0&& Math.max( cost[a][b], Math.abs(h[a][b-1] - h[a][b]) ) < cost[a][b-1] )
            {
                cost[a][b-1] = Math.max( cost[a][b], Math.abs(h[a][b-1] - h[a][b]) );
                 pq.add(new Pair(a,b-1,cost[a][b-1]));
            }
        }
        return cost[r-1][c-1];
    }
}