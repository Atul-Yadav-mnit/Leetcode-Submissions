class Solution {
    public int[] arrayChange(int[] nums, int[][] o) {
        HashMap<Integer,ArrayList<Integer>> h = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            if(h.containsKey(nums[i]))
            {
                h.get(nums[i]).add(i);
            }
            else
            {
                ArrayList<Integer> t = new ArrayList<Integer>();
                t.add(i);
                h.put(nums[i],t);
            }
        }
        for(int i=0;i<o.length;i++)
        {
            ArrayList<Integer> t = h.remove(o[i][0]);
            h.put(o[i][1],t);
        }
        h.forEach((k,v) -> {
            for(int i=0;i<v.size();i++)
            {
                nums[v.get(i)] = k;
            }
        });
        return nums;
    }
}