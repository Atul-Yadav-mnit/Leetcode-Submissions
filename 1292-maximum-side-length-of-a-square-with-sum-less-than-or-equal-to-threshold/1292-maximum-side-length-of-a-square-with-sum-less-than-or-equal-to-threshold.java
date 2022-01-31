class Solution {
    public boolean fun(int mat[][], int m ,int th)
    {
        for(int i=1;i+m<=mat.length;i++)
        {
            for(int j=1;j+m<=mat[0].length;j++)
            {
                // i,j  to i+m-1  j+m-1
                int sum = mat[i+m-1][j+m-1]-mat[i+m-1][j-1]-mat[i-1][j+m-1]+mat[i-1][j-1];
                if(sum<=th)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int th) {
        int m = mat.length;
        int n = mat[0].length;
        int sum[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                sum[i][j] = sum[i-1][j]+sum[i][j-1]+mat[i-1][j-1]-sum[i-1][j-1];
            }
        }
        int ans = 0;
        int l = 1;
        int h = Math.min(m,n);
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            if(fun(sum,mid,th))
            {
                ans = mid;
                l = mid+1;
            }
            else
            {
                h = mid-1;
            }
        }
        return ans;
    }
}