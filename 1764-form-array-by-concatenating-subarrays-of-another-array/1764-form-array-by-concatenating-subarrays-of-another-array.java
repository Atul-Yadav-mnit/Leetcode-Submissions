class Solution {
    public boolean canChoose(int[][] g, int[] nums) {
        int i = 0;
        int r = 0;
        int c = 0;
        int st = i;
        while(r<g.length)
        {
            if(i == nums.length)
            {
                return false;
            }
            if(nums[i] == g[r][c])
            {
                c++;
                i++;
                if(c == g[r].length)
                {
                    r++;
                    c= 0;
                    st = i;
                }
            }
            else
            {
                st++;
                i = st;
                c = 0;
            }
        }
        return true;
    }
}