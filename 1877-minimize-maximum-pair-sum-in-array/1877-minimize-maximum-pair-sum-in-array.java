class Solution {
    public int minPairSum(int[] nums) {
        int min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<nums.length/2;i++)
        {
            min = Math.max(min,nums[i]+nums[n-i-1]);
        }
        return min;
    }
}