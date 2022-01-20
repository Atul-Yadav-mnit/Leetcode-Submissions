class Solution {
    public boolean fun(int arr[], int m,int h)
    {
        int req = 0;
        for(int i=0;i<arr.length;i++)
        {
            req+=(arr[i]+(m-1))/m;
        }
        return req<=h;
    }
    public int minEatingSpeed(int[] piles, int hours) {
        int l = 1;
        int h = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            h = Math.max(h,piles[i]);
        }
        int ans = 0;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(fun(piles,m,hours))
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