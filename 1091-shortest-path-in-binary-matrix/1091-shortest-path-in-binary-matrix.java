class Solution {
    public boolean isvalid(int x, int y, int grid[][])
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=0)
        {
            
            return false;
        }
        grid[x][y] = -1;
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int nn = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[nn-1][m-1] == 1)
        {
            return -1;
        }
        ArrayDeque<Integer> r = new ArrayDeque<Integer>();
        ArrayDeque<Integer> c = new ArrayDeque<Integer>();
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        r.addLast(0);
        c.addLast(0);
        s.addLast(1);
        grid[0][0] = -1;
        while(r.size()>0)
        {
            int x = r.removeFirst();
            int y = c.removeFirst();
            int n = s.removeFirst();
            if(x==nn-1 && y == m-1)
            {
                return n;
            }
            if(isvalid(x+1,y,grid))
            {
                r.add(x+1);
                c.add(y);
                s.add(n+1);
            }
            if(isvalid(x-1,y,grid))
            {
                r.add(x-1);
                c.add(y);
                s.add(n+1);
            }
            if(isvalid(x,y+1,grid))
            {
                r.add(x);
                c.add(y+1);
                s.add(n+1);
            }
            if(isvalid(x,y-1,grid))
            {
                r.add(x);
                c.add(y-1);
                s.add(n+1);
            }
            if(isvalid(x+1,y+1,grid))
            {
                r.add(x+1);
                c.add(y+1);
                s.add(n+1);
            }
            if(isvalid(x+1,y-1,grid))
            {
                r.add(x+1);
                c.add(y-1);
                s.add(n+1);
            }
            if(isvalid(x-1,y+1,grid))
            {
                r.add(x-1);
                c.add(y+1);
                s.add(n+1);
            }
            if(isvalid(x-1,y-1,grid))
            {
                r.add(x-1);
                c.add(y-1);
                s.add(n+1);
            }
        }
        return -1;
    }
}