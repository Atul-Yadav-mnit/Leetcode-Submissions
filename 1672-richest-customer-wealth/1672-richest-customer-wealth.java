class Solution {
    public int maximumWealth(int[][] wealth) {
        int max = 0;
        for(int i=0;i<wealth.length;i++)
        {
            int temp=0;
            for(int j=0;j<wealth[0].length;j++)
            {
                temp+=wealth[i][j];
            }
            max = Math.max(max,temp);
        }
        return max;
    }
}