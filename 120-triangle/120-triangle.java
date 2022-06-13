class Solution {
    List<List<Integer>> t;
    int dp[][];
    public int fun(int x, int y)
    {
        if(x == t.size())
        {
            return 0;
        }
        if(dp[x][y] != -1)
        {
            return dp[x][y];
        }
        int min = t.get(x).get(y)+fun(x+1,y);
        if(y+1<t.get(x).size())
        {
            min = Math.min(min,t.get(x).get(y+1)+fun(x+1,y+1));
        }
        return dp[x][y] = min;
    }
    public int minimumTotal(List<List<Integer>> t) {
        dp = new int[t.size()][];
        for(int i=0;i<t.size();i++)
        {
            dp[i] = new int[i+1];
            Arrays.fill(dp[i],-1);
        }
        this.t = t;
        return t.get(0).get(0)+fun(1,0);
    }
}