class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        int min = Integer.MAX_VALUE;
        if(left[0] == x || right[n-1] == x)
        {
            return 1;
        }
        for(int i=1;i<n;i++)
        {
            left[i] = left[i-1]+nums[i];
            if(left[i] == x)
            {
                min = Math.min(i+1,min);
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            right[i]  = right[i+1]+nums[i];
            if(right[i] == x)
            {
                min = Math.min(n-i,min);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(left[i]>x)
            {
                break;
            }
            int rem = x-left[i];
            int l = i+1;
            int h = n-1;
            int r = -1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                if(right[m] == rem)
                {
                    r = m;
                    l = m+1;
                }
                else if(right[m] < rem)
                {
                    h = m-1;
                }
                else
                {
                    l = m+1;
                }
            }
            if(r!=-1)
            {
                min = Math.min(min,n-r+i+1);
            }
        }
        if(min == Integer.MAX_VALUE)
        {
            return -1;
        }
        return min;
    }
}