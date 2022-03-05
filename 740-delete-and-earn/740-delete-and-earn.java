class Solution {
    ArrayList<Integer> arr;
    ArrayList<Integer> count;
    int t[];
    public int fun(int x)
    {
        if(x>=arr.size())
        {
            return 0;
        }
        if(t[x]!=-1)
        {
            return t[x];
        }
        if(x==arr.size()-1)
        {
            return t[x] = arr.get(x)*count.get(x);
        }
        else
        {
            int a = arr.get(x+1);
            int b = arr.get(x);
            if(a == b+1)
            {
                return t[x] = Math.max( arr.get(x)*count.get(x)+fun(x+2) , fun(x+1));
            }
            else
            {
                return t[x] = arr.get(x)*count.get(x)+fun(x+1);
            }
        }
        
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        t = new int[nums.length+1];
        Arrays.fill(t,-1);
        arr = new ArrayList<Integer>();
        count = new ArrayList<Integer>();
        int cur = nums[0];
        int cc = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == cur)
            {
                cc++;
            }
            else
            {
                arr.add(cur);
                count.add(cc);
                cur = nums[i];
                cc = 1;
            }
        }
        arr.add(cur);
        count.add(cc);
        return fun(0);
    }
}