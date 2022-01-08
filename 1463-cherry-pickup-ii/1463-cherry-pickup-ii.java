class Solution {
    public int grid[][];
    public int t[][][];
    public int ans(int x, int y1, int y2)
    {
        if(y1>=0 && y1<grid[0].length && y2>=0 && y2<grid[0].length)
        {
            if(y1 == y2)
            {
                return grid[x][y1];
            }
            else
            {
                return grid[x][y1] + grid[x][y2];
            }
        }
        else
        {
            return -1;
        }
    }
    
    public int fun(int x, int y1, int y2, int grid[][])
    {
        if(x == grid.length || y1<0 || y1>=grid[0].length || y2<0 || y2>=grid[0].length)
        {
            return 0;
        }
        else
        {
            if(t[x][y1][y2] != -1)
            {
                return t[x][y1][y2];
            }
            int max = 0;
            // y1      y2 y2-1 y2+1
            max = Math.max(max,fun(x+1,y1,y2,grid));
            max = Math.max(max,fun(x+1,y1,y2+1,grid));
            max = Math.max(max,fun(x+1,y1,y2-1,grid));
            max = Math.max(max,fun(x+1,y1+1,y2,grid));
            max = Math.max(max,fun(x+1,y1+1,y2+1,grid));
            max = Math.max(max,fun(x+1,y1+1,y2-1,grid));
            max = Math.max(max,fun(x+1,y1-1,y2,grid));
            max = Math.max(max,fun(x+1,y1-1,y2+1,grid));
            max = Math.max(max,fun(x+1,y1-1,y2-1,grid));
            return t[x][y1][y2] = max+ans(x,y1,y2);
        }
    }
    public int cherryPickup(int[][] g) {
        grid = g;
        t = new int[grid.length+1][grid[0].length+1][grid[0].length+1];
        for(int i =0;i<grid.length+1;i++)
        {
            for(int j=0;j<grid[0].length+1;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        return fun(0,0,grid[0].length-1,g);
    }
}