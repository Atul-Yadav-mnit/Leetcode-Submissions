class Solution {
    public int grid[][];
    public int fun(int x, int y)
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length)
        {
            return 0;
        }
        else
        {
            return grid[x][y]%10;
        }
    }
    public void gameOfLife(int[][] board) {
        grid = board;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int c = 0;
                int x = i;
                int y = j;
                c+=fun(x-1,y-1);
                c+=fun(x-1,y);
                c+=fun(x-1,y+1);
                c+=fun(x,y-1);
                c+=fun(x,y+1);
                c+=fun(x+1,y-1);
                c+=fun(x+1,y);
                c+=fun(x+1,y+1);
                if(board[i][j] == 1)
                {
                    if(c==2 || c==3)
                    {
                        board[i][j] = 11;
                    }
                }
                else
                {
                    if(c == 3)
                    {
                        board[i][j] = 10;
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j] /= 10;
            }
        }
    }
}