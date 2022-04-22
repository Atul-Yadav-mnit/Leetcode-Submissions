class Solution {
    int t[][];
    public int fun(int nums1[], int nums2[], int x, int y)
    {
        if(x == nums1.length || y == nums2.length)
        {
            return 0;
        }
        if(t[x][y] != -1)
        {
            return t[x][y];
        }
        int ans =0 ;
        for(int j=y;j<nums2.length;j++)
        {
            if(nums2[j] == nums1[x])
            {
                ans = 1+fun(nums1,nums2,x+1,j+1);
                break;
            }
        }
        return t[x][y] = Math.max(ans,fun(nums1,nums2,x+1,y));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        t = new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(nums1,nums2,0,0);
    }
}