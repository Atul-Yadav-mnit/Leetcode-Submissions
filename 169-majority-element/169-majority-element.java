class Solution {
    public int majorityElement(int[] nums) {
        int x = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == x)
            {
                count++;
            }
            else
            {
                
                if(count>0)
                {
                    count--;
                }
                else
                {
                    count=1;
                    x = nums[i];
                }
            }
        }
        return x;
    }
}