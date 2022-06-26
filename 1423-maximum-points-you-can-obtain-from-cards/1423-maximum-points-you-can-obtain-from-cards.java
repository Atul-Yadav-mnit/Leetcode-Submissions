class Solution {

    public int maxScore(int[] c, int k) {
        int left[] = new int[c.length];
        int right[] = new int[c.length];
        left[0] = c[0];
        for(int i=1;i<c.length;i++)
        {
            left[i] = left[i-1]+c[i];
        }
        right[c.length-1] = c[c.length-1];
        for(int i=c.length-2;i>=0;i--)
        {
            right[i] = right[i+1]+c[i];
        }
        int max = right[c.length-1-k+1];
        for(int i=0;i<k-1;i++)
        {
            int sum = left[i] + right[c.length-1-(k-(i+1))+1];
            max = Math.max(max,sum);
        }
        max = Math.max(max,left[k-1]);
        return max;
    }
}