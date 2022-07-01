class Solution {
    public int maximumUnits(int[][] b, int t) {
        Arrays.sort(b,(b1,b2)->b2[1]-b1[1]);
        int ans = 0;
        for(int i=0;i<b.length;i++)
        {
            if(b[i][0] < t)
            {
                t-=b[i][0];
                ans+=b[i][1]*b[i][0];
            }
            else{
                ans+=b[i][1]*t;
                break;
            }
        }
        return ans;
    }
}