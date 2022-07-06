class Solution {
    public int[][] mat(int x[][], int y[][])
    {
        int ans[][] = new int[2][2];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<2;k++)
                {
                    ans[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return ans;
    }
    public int[][] fun(int m[][], int y)
    {
        if(y == 1)
        {
            return m;
        }
        int t[][] = fun(m,y/2);
        int ans[][] = mat(t,t);
        if(y%2==1)
        {
            ans = mat(m,ans);
        }
        return ans;
    }
    public int fib(int n) {
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
       int x = n/2;
       int m[][] = {{1,1},{1,2}};
       m = fun(m,x);
       if(n%2 == 0)
       {
           return m[0][1];
       }
        return m[1][1];
    }
}