class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+2;
        int i=0;
        int j =0;
        int cur = 0;
        while(i<nums.length)
        {
            if(cur >= target)
            {
                min = Math.min(j-i,min);
                cur-=nums[i];
                i++;
            }
            else if(j<nums.length)
            {
                 cur+=nums[j];
                 j++;
            }
            else
            {
                break;
            }
            
        }
        return min%(nums.length+2);
    }
}