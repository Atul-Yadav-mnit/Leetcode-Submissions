class Solution {
    public int maxArea(int lh, int lw, int[] h, int[] v) {
        long m = 1000000007;
        Arrays.sort(h);
        Arrays.sort(v);
        int maxh = h[0],maxv = v[0];
        for(int i=1;i<h.length;i++)
        {
            maxh = Math.max(maxh,h[i]-h[i-1]);
        }
        maxh = Math.max(maxh,lh-h[h.length-1]);
        
         for(int i=1;i<v.length;i++)
        {
            maxv = Math.max(maxv,v[i]-v[i-1]);
        }
        maxv = Math.max(maxv,lw-v[v.length-1]);
        
        long ans = (long)maxh%m * (long)maxv%m;
        return (int)(ans%m);
    }
}