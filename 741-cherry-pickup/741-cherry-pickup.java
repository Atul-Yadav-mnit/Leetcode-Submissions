class Solution {
    public int t[][][][];
    public int fun(int x1, int y1, int x2, int y2, int grid[][])
    {
        int n = grid.length;
        
        if(x1 == n-1 && y1 == n-1 && x2==n-1 && y2==n-1 )
        {
            return grid[x1][y1];
        }
        else if(x1 == n-1 && y1 == n-1 && x2==n-1 && y2==n-1)
        {
            return -999999;
        }
        else
        {
            if(t[x1][y1][x2][y2]!=-1){
                return t[x1][y1][x2][y2];
            }
            int ans = -999999;
            
            
          
                           int temp1 = grid[x1][y1];
                grid[x1][y1] = 0;
                int temp2 = grid[x2][y2];
                grid[x2][y2] = 0;
            if(x1+1<n && grid[x1+1][y1]!=-1 && x2+1<n && grid[x2+1][y2]!=-1 )
            {
                // case 1

                ans = Math.max(ans, temp1+temp2+fun(x1+1,y1,x2+1,y2,grid) );
                
                
            }
            if(x1+1<n && grid[x1+1][y1]!=-1 && y2+1<n && grid[x2][y2+1]!=-1 )
            {
                ans = Math.max(ans, temp1+temp2+fun(x1+1,y1,x2,y2+1,grid) );
            }
            if(y1+1<n && grid[x1][y1+1]!=-1 && x2+1<n && grid[x2+1][y2]!=-1 )
            {
                ans = Math.max(ans, temp1+temp2+fun(x1,y1+1,x2+1,y2,grid) );
                
            }
            if(y1+1<n && grid[x1][y1+1]!=-1 && y2+1<n && grid[x2][y2+1]!=-1 )
            {
                ans = Math.max(ans, temp1+temp2+fun(x1,y1+1,x2,y2+1,grid) );
                
            }
            grid[x2][y2] = temp2;
                grid[x1][y1] = temp1;
            return t[x1][y1][x2][y2] = ans;
            
            
            
        }
        
       
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        t = new int[n][n][n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                Arrays.fill(t[i][j][k],-1);
            }
        }
        return Math.max(0,fun(0,0,0,0,grid));
    }
}