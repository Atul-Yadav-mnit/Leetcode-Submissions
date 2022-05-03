class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        left[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            left[i] = Math.min(left[i+1],nums[i]);
        }
        
        int right[] = new int[n];
        right[0] = nums[0];
        for(int i=1;i<n;i++)
        {
            right[i] = Math.max(right[i-1],nums[i]);
        }
        
        int l=-1,r=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i] > left[i])
            {
                l = i;
                break;
            }
        }
        if(l == -1)
        {
            return 0;
        }
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i] < right[i])
            {
                r = i;
                break;
            }
        }
        if(r == -1)
        {
            return 0;
        }
        return r-l+1;
    }
}