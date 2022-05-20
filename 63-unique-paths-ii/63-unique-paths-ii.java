class Solution {
    int t[][];
    public int fun(int g[][], int x, int y)
    {
        if(x<0 || y<0 || x>=g.length || y>=g[0].length || g[x][y]==1)
        {
            return 0;
        }
        if(t[x][y] != -1)
        {
            return t[x][y];
        }
        if(x == g.length-1 && y == g[0].length-1)
        {
            return 1-g[x][y];
        }
        return t[x][y] = fun(g,x+1,y)+fun(g,x,y+1);
    }
    public int uniquePathsWithObstacles(int[][] g) {
        t = new int[g.length][g[0].length];
        for(int i=0;i<g.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(g,0,0);
    }
}