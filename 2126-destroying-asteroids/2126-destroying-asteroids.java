class Solution {
    public boolean asteroidsDestroyed(int mss, int[] a) {
        Arrays.sort(a);
        long mass = mss;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>mass)
            {
                return false;
            }
            mass+=a[i];
        }
        return true;
    }
}