class Solution {
    public boolean fun(int h[], int e[], int r)
    {
        int i = 0;
        int j = 0;
        while(i<h.length)
        {
            int low = e[j]-r;
            int high = e[j]+r;
            if(h[i] >= low && h[i]<=high)
            {
                i++;
            }
            else
            {
                if(j+1 == e.length)
                {
                    return false;
                }
                j++;
            }
        }
        return true;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int h = 1000000002;
        int ans = h;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(fun(houses,heaters,m))
            {
                ans = m;
                h = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        return ans;
    }
}