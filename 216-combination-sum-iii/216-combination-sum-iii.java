class Solution {
    
    public List<List<Integer>> fun(int k, int sum, int cur)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(k == 0)
        {
            if(sum == 0)
            {
                ans.add(new ArrayList<Integer>());
                return ans;
            }
            else
            {
                return ans;
            }
        }
        if(cur > 9)
        {
            return ans;
        }
        if(sum>=cur)
        {
            List<List<Integer>> t1 = fun(k,sum,cur+1);
            ans.addAll(t1);
            List<List<Integer>> t2 = fun(k-1,sum-cur,cur+1);
            for(int i=0;i<t2.size();i++)
            {
                t2.get(i).add(cur);
            }
            ans.addAll(t2);
            return ans;
        }
        else
        {
            return fun(k,sum,cur+1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        return fun(k,n,1);
    }
}