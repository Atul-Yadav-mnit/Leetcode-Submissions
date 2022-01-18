class Solution {
    public int right(int arr[], int x)
    {
        int l = 0;
        int h = arr.length-1;
        int ans = 0;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(arr[m] > x)
            {
                h = m-1;
            }
            else
            {
                ans = m;
                l = m+1;
            }
        }
        return ans;
    }
    
    public int left(int arr[], int x)
    {
        int l = 0;
        int h = arr.length-1;
        int ans = arr.length-1;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(arr[m] < x)
            {
                l = m+1;
            }
            else
            {
                ans = m ;
                h = m-1;
            }
        }
        return ans;
    }
    
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int same[] = new int[nums.length];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == nums[i-1])
            {
                same[i] = same[i-1]+1;
            }
            else
            {
                same[i] = same[i-1];
            }
        }
        int count = nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0 && nums[i]==nums[i-1]+1)
            {
                continue;
            }
            int l = nums[i];
            int h = l+nums.length-1;
            int li = left(nums,l);
            int ri = right(nums,h);
            int sm = same[ri]-same[li];
            int cur = Math.max(0,ri-li+1-sm);
         //   System.out.println(l+" "+h+" "+cur+" "+right(nums,h)+" "+left(nums,l));
            count = Math.min(count,nums.length-cur);
        }
        return count;
    }
}