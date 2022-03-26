class Solution {
    public double t[][][],sum[];
    public double fun(int arr[], int k, int x, int prev)
    {
        if(x == arr.length)
        {
            if(prev == x)
            {
                return 0.0;
            }
            return (sum[x-1]-sum[prev]+arr[prev])/(x-prev);
        }
        if(t[x][prev][k] !=-99999999.0)
        {
            return t[x][prev][k];
        }
        if(k == 1)
        {
             t[x][prev][k] = fun(arr,k,x+1,prev);
        }
        else
        {
            double a = fun(arr,k,x+1,prev);
            double s = (sum[x]-sum[prev]+arr[prev]) / (x-prev+1);
            double b = s + fun(arr,k-1,x+1,x+1);
            t[x][prev][k] = Math.max(a,b);
        }
      //  System.out.println(x+" "+prev+" "+k+" "+t[x][prev][k] );
        return  t[x][prev][k];
    }
    public double largestSumOfAverages(int[] nums, int k) {
        sum = new double[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum[i] = sum[i-1]+nums[i];
        }
        int n = nums.length;
        t = new double[n][n][k+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                Arrays.fill(t[i][j],-99999999.0);
            }
        }
        return fun(nums,k,0,0);
    }
}