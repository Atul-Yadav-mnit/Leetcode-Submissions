class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<nums4.length;i++)
        {
            for(int j=0;j<nums3.length;j++)
            {
                int sum = nums4[i]+nums3[j];
                if(h.containsKey(sum))
                {
                    int x = h.get(sum);
                    h.put(sum,x+1);
                }
                else
                {
                    h.put(sum,1);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                int sum = nums1[i]+nums2[j];
                if(h.containsKey(0-sum))
                {
                    ans += h.get(0-sum);
                    
                }
                
            }
        }
        return ans;
    }
}