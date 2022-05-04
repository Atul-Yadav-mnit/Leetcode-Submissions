class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int a = nums[i];
            int b = k-nums[i];
            if( h.containsKey(b) == true && h.get(b) >= 1 )
            {
                int x = h.remove(b);
                h.put(b,x-1);
                ans++;
            }
            else if( h.containsKey(a) == true )
            {
                h.put(a,h.get(a)+1);
            }
            else
            {
                h.put(a,1);
            }
        }
        return ans;
    }
}