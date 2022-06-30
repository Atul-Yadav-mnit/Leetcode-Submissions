class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long left = 0;
        long right = 0;
        for(int i=0;i<nums.length;i++)
        {
            right += nums[i];
        }
        long min = Long.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            left += nums[i];
            right -= nums[i];
            long count = (i+1)*(long)nums[i] - left;
            count += right - (long)nums[i]*(nums.length-i-1);
            if(count < min)
            {
                min = count;
            }
        }
        return (int)min;
    }
}