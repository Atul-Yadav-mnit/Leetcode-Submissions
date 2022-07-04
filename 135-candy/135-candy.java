class Solution {
    public int candy(int[] r) {
        int left[] = new int[r.length];
        int right[] = new int[r.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1;i<r.length;i++)
        {
            if(r[i] > r[i-1])
            {
                left[i] = left[i-1]+1;
            }
        }
         for(int i=r.length-2;i>=0;i--)
        {
            if(r[i] > r[i+1])
            {
                right[i] = right[i+1]+1;
            }
        }
        int ans = 0;
        for(int i=0;i<r.length;i++)
        {
            ans+=Math.max(left[i],right[i]);
        }
        return ans;
    }
}