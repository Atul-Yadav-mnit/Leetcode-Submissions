class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int k=0;k<l.length;k++)
        {
            int st = l[k];
            int ep = r[k];
            int temp[] = new int[ep-st+1];
            for(int i=st;i<=ep;i++)
            {
                temp[i-st] = nums[i];
            }
            Arrays.sort(temp);
            boolean a = true;
            for(int i=2;i<=ep-st;i++)
            {
                if(temp[i]-temp[i-1] != temp[i-1]-temp[i-2])
                {
                    a= false;
                    break;
                }
            }
            ans.add(a);
        }
        return ans;
    }
}