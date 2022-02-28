class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        StringBuilder s = null;
        List<String> ans = new ArrayList<String>();
        if(nums.length == 0)
        {
            return ans;
        }
        s = new StringBuilder();
        s.append(nums[0]);
        int cur = nums[0];
        int start = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == cur+1)
            {
                cur++;
            }
            else
            {
                if(cur != start)
                {
                    s.append("->");
                    s.append(cur);
                }
                ans.add(s.toString());
                cur = nums[i];
                start = nums[i];
                s = new StringBuilder();
                s.append(nums[i]);
            }
        }
        if(cur != start)
        {
            s.append("->");
            s.append(cur);
        }
        ans.add(s.toString());
        return ans;
    }
}