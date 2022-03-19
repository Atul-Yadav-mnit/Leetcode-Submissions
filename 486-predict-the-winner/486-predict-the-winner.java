class Solution {
    public int t[][];
    public int fun(int nums[], int l, int h)
    {
        if(l == h)
        {
            return nums[h];
        }
        if(l>h)
        {
            return 0;
        }
        if(t[l][h]!=-1)
        {
            return t[l][h];
        }
        int a1 = nums[l]+Math.min(fun(nums,l+1,h-1),fun(nums,l+2,h));
        int a2 = nums[h]+Math.min(fun(nums,l+1,h-1),fun(nums,l,h-2));
        return t[l][h] = Math.max(a1,a2);
    }
    public boolean PredictTheWinner(int[] nums) {
        t = new int[nums.length][nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(t[i],-1);
            sum+=nums[i];
        }
        int x =fun(nums,0,nums.length-1);
        if(x >= sum-x)
        {
            return true;
        }
        return false;
    }
}