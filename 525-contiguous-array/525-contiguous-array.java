class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nums[i] = -1;
            }
        }
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        h.put(0,-1);
        int sum = 0, max = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(h.containsKey(sum))
            {
                max = Math.max(max,i-h.get(sum));
            }
            else //(h.containsKey(sum))
            {
                h.put(sum,i);
            }
            
        }
        return max;
    }
}