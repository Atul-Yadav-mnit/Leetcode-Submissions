class Solution {
    List<List<Integer>> fans;
    int n;
    public void fun(HashMap<Integer,Integer> h,ArrayList<Integer> ans, int len)
    {
       
        if(len == 0)
        {
            ArrayList<Integer> a = new ArrayList<Integer>(ans);
            fans.add(a);
        }
        else
        {
            for(int i=-10;i<=10;i++)
            {
                if(h.containsKey(i))
                {
                    int y = h.get(i);
                    if(y == 1)
                    {
                        h.remove(i);
                    }
                    else
                    {
                        h.put(i,y-1);
                    }
                    ans.add(i);
                    fun(h,ans,len-1);
                    h.put(i,y);
                    ans.remove(n-len);
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        fans = new ArrayList<List<Integer>>();
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(h.containsKey(nums[i]))
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
            else
            {
                h.put(nums[i],1);
            }
        }
        n = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        fun(h,ans,nums.length);
        return fans;
    }
}