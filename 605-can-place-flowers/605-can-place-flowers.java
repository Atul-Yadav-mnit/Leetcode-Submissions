class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        int count = 0;
        //  1 -> 3
        //  2 -> 5
        //  3 -> 7
        int prev = -2;
        for(int i=0;i<f.length;i++)
        {
            if(f[i] == 1)
            {
                 int nn = i-prev-1;
                 count += Math.max(0,(nn-1)/2);
                 prev = i;
            }
        }
        int nn = f.length-prev;
        count += Math.max(0,(nn-1)/2);
        return count >= n;
    }
}