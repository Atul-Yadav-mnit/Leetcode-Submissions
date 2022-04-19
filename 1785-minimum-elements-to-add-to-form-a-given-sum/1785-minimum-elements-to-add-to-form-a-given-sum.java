class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        long diff = Math.abs((long)goal-sum);
        long ans = diff/(long)limit;
        if(diff%(long)limit != 0)
        {
            ans++;
        }
        return (int)ans;
    }
}