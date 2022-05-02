class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int odd = -1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                if(odd==-1)
                {
                    
                }
                else
                {
                    int t = nums[odd];
                    nums[odd] = nums[i];
                    nums[i] = t;
                    odd++;
                }
            }
            else
            {
                if(odd == -1)
                {
                    odd = i;
                }
            }
        }
        return nums;
    }
}