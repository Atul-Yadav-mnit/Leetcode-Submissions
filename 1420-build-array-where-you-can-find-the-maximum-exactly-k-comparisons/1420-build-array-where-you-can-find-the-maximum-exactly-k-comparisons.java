class Solution {
    public long n,m,z=1000000007,t[][][];
    public long fun(long x, long max_till_now,int k){
        if(x == n)
        {
            if(k == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(t[(int)x][(int)max_till_now][k] != -1)
        {
            return t[(int)x][(int)max_till_now][k];
        }
        if(k>0)
        {
            long ans = ((max_till_now)%z*fun(x+1,max_till_now,k)%z)%z;
            for(long i=max_till_now+1;i<=m;i++)
            {
                ans = (ans%z + fun(x+1,i,k-1)%z)%z;
            }
            return t[(int)x][(int)max_till_now][k] = ans;
        }
        else
        {
            long ans = ((max_till_now)%z*fun(x+1,max_till_now,k)%z)%z;
            return t[(int)x][(int)max_till_now][k]  = ans;
        }
    }
    
    public int numOfArrays(int n, int m, int k) {
        t = new long[n+1][m+1][k+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        this.n = n;
        this.m = m;
        return (int)fun(0,0,k);
    }
    
}