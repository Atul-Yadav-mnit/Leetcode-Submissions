class Solution {
    int t[][][];
    public int fun(int m[][], int x, int y, int z)
    {
        int px = x;
        int py = y;
        if(z == 1)
        {
            px--;
        }
        else if(z == 2)
        {
            px++;
        }
        else if(z == 3)
        {
            py++;
        }
        else
        {
            py--;
        }
        if(x<0 || y<0 || x>=m.length || y>=m[0].length || m[x][y] <= m[px][py])
        {
            return 0;
        }
        if(t[x][y][z]!=-1)
        {
            return t[x][y][z];
        }
        int max = 1;
        max = Math.max(max,1+fun(m,x+1,y,1));
        max = Math.max(max,1+fun(m,x-1,y,2));
        max = Math.max(max,1+fun(m,x,y-1,3));
        max = Math.max(max,1+fun(m,x,y+1,0));
        return t[x][y][z] = max;
    }
    public int longestIncreasingPath(int[][] m) {
        int max = 0;
        t = new int[m.length][m[0].length][4];
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
               Arrays.fill(t[i][j] , -1);
            }
        }
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                max = Math.max(max,1+fun(m,i+1,j,1));
                max = Math.max(max,1+fun(m,i-1,j,2));
                max = Math.max(max,1+fun(m,i,j-1,3));
                max = Math.max(max,1+fun(m,i,j+1,0));
            }
        }
        return  max;
    }
}