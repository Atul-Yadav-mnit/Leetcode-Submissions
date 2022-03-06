class Solution {
    long t[][];
    long m = 1000000007;
    public long fun(int left, int pic)
    {
        if(t[left][pic] != -1)
        {
            return t[left][pic];
        }
        if(left == 0)
        {
            long ans = 1;
            for(int i=2;i<=pic;i++)
            {
                ans = (ans%m * i%m)%m;
            }
            return t[left][pic] = ans%m;
        }
        if(pic>0)
        {
            long a1 = (left%m*fun(left-1,pic+1)%m)%m;
            long a2 = (pic%m*fun(left,pic-1)%m)%m;
            return t[left][pic] = (a1%m+a2%m)%m;
        }
        else
        {
            return t[left][pic] = (left%m*fun(left-1,pic+1)%m)%m;
        }
    }
    public int countOrders(int n) {
        t = new long[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return (int)fun(n,0);
    }
}