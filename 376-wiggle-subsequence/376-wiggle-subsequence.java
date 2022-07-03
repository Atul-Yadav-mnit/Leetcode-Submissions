class Solution {
    int t[][][];
    public int fun(int nums[],int x, int p, int type)
    {
        if(x == nums.length)
        {
            return 0;
        }
        if( t[x][p][type] != -1)
        {
            return t[x][p][type];
        }
        if(type == 2)
        {
            int ans = Math.max(1+fun(nums,x+1,x,0),1+fun(nums,x+1,x,1));
            return t[x][p][type] = Math.max(ans,fun(nums,x+1,x+1,2));
        }
        int ans = 0;
        if(nums[x] > nums[p] && type == 1)
        {
            ans = Math.max(ans,1+fun(nums,x+1,x,0));
        }
        else if(nums[x] < nums[p] && type == 0)
        {
            ans = Math.max(ans,1+fun(nums,x+1,x,1));
        }
        ans = Math.max(ans,fun(nums,x+1,p,type));
        return t[x][p][type] = ans;
    }
    public int wiggleMaxLength(int[] nums) {
        t = new int[nums.length][nums.length][3];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        return fun(nums,0,0,2);
    }
}