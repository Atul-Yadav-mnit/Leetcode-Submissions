class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int adj[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        int vis[] = new int[n];
        int cost[] = new int[n];
        Arrays.fill(cost,999999999);
        cost[0] = 0;
        int count = 0;
        for(int i=0;i<n;i++)
        {
            int min = 99999999;
            int mini = -1;
            for(int j=0;j<n;j++)
            {
                if(vis[j] == 0 && cost[j]<=min)
                {
                    min = cost[j];
                    mini = j;
                }
            }
            //System.out.println(mini);
            vis[mini] = 1;
            count += cost[mini];
            //System.out.println(cost[mini]);
            for(int j=0;j<n;j++)
            {
                if(vis[j] == 0 && adj[mini][j] < cost[j])
                {
                    cost[j] = adj[mini][j];
                }
            }
        }
        return count;
    }
}