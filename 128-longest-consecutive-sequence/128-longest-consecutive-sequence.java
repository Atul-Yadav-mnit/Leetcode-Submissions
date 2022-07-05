class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        for(int x:nums)
        {
            h.add(x);
        }
        int ans = 0;
        for(int x:h)
        {
            if(h.contains(x-1))
            {
                continue;
            }
            else
            {
                int count = 1;
                int y = x+1;
                while(h.contains(y))
                {
                    y++;
                    count++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}