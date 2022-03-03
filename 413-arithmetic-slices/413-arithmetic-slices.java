class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2)
        {
            return 0;
        }
        int ans = 0;
        int cur = nums[1]-nums[0];
        int curst = 0;
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1] == cur)
            {
                ans+=(i-curst-1);
            }
            else
            {
                curst = i-1;
                cur = nums[i]-nums[i-1];
            }
        }
        return ans;
    }
}