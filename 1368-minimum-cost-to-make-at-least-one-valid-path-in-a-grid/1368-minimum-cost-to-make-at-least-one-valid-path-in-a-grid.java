class Solution {
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost[][] = new int[m][n];
        int vis[][] = new int[m][n];
      
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                cost[i][j] = 1000000;
            }
        }
        cost[0][0] = 0;
        int count = 0;
        while(count<m*n)
        {
            count++;
            int x = 0;
            int y = 0;
            int c = 0;
            int min = -1;
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(min == -1 && vis[i][j] == 0)
                    {
                        x = i;
                        y = j;
                        min = 1;
                        c = cost[i][j];
                    }
                    else if(min!=-1 && cost[i][j]<c && vis[i][j] == 0)
                    {
                        c = cost[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            int z = c;
            vis[x][y] =  1;
            if(x+1<m && vis[x+1][y]==0)
            {
                if(grid[x][y] == 3)
                {
                    cost[x+1][y] = Math.min(cost[x+1][y],cost[x][y]);
                }
                else
                {
                    cost[x+1][y] = Math.min(cost[x+1][y],cost[x][y]+1);
                }
            }
            if(x-1>=0 && vis[x-1][y]==0)
            {
                if(grid[x][y] == 4)
                {
                    cost[x-1][y] = Math.min(cost[x-1][y],cost[x][y]);
                }
                else
                {
                    cost[x-1][y] = Math.min(cost[x-1][y],cost[x][y]+1);
                }
            }
            if(y+1<n && vis[x][y+1] == 0)
            {
                if(grid[x][y] == 1)
                {
                    cost[x][y+1] = Math.min(cost[x][y+1],cost[x][y]);
                }
                else
                {
                    cost[x][y+1] = Math.min(cost[x][y+1],cost[x][y]+1);
                }
            }
            if(y-1>=0 && vis[x][y-1]==0)
            {
              //  System.out.println(x+" "+(y-1)+" "+"ewni"+" "+cost[x][y-1]+" "+cost[x][y]+" "+gri);
               
                if(grid[x][y] == 2)
                {
                     
                    cost[x][y-1] = Math.min(cost[x][y-1],cost[x][y]);
                }
                else
                {
                    cost[x][y-1] = Math.min(cost[x][y-1],cost[x][y]+1);
                }
            }
            
            
        }
        return cost[m-1][n-1];
    }
}