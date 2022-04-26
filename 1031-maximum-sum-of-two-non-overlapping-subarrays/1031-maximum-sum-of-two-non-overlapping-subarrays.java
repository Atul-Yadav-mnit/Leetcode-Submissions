class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        int fs[] = new int[nums.length];
        int ss[] = new int[nums.length];
        int tfs[] = new int[nums.length];
        int tss[] = new int[nums.length];
        int sum = 0;
        for(int i=0;i<f;i++)
        {
            sum+=nums[i];
        }
        fs[f-1] = sum;
        tfs[f-1] = sum;
        for(int i=f;i<nums.length;i++)
        {
            fs[i] = fs[i-1]+nums[i]-nums[i-f]; 
            tfs[i] = fs[i];
        }
        sum = 0;
        for(int i=0;i<s;i++)
        {
            sum+=nums[i];
        }
        ss[s-1] = sum;
        tss[s-1] = sum;
        for(int i=s;i<nums.length;i++)
        {
            ss[i] = ss[i-1]+nums[i]-nums[i-s]; 
            tss[i] = ss[i];
        }
        
        for(int i=nums.length-2;i>=0;i--)
        {
            ss[i] = Math.max(ss[i+1],ss[i]); 
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            fs[i] = Math.max(fs[i+1],fs[i]); 
        }
       
        
        int ans  = 0;
        for(int i = 0;i+f+s<=nums.length;i++)
        {
            ans = Math.max(tfs[i+f-1]+ss[i+f+s-1],ans);
           // System.out.println((i+f-1)+" "+(i+f+s-1));
        }
        for(int i = 0;i+f+s<=nums.length;i++)
        {
            ans = Math.max(tss[i+s-1]+fs[i+s+f-1],ans);
        }
        return ans;
    }
}