class Solution {
    public boolean fun(int q[], int m,int n)
    {
        int count = 0;
        for(int i=0;i<q.length;i++)
        {
            count += (q[i]+m-1)/m;
        }
        return count<=n;
    }
    public int minimizedMaximum(int n, int[] q) {
        long sum = 0;
        int h = -1;
        for(int i=0;i<q.length;i++)
        {
            sum+=q[i];
            h = Math.max(h,q[i]);
        }
        sum = (sum+(n-1))/n;
        int l = (int)sum;
        int ans = 0;
       // System.out.println(l+" "+h);
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(fun(q,m,n))
            {
                ans = m;
                h = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        return ans;
    }
}