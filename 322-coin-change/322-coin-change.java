class Solution {
    int t[][];
    int fun(int c[], int x, int s)
    {
        if(x == c.length)
        {
            if(s == 0)
            {
                return 0;
            }
            else
            {
                return Integer.MAX_VALUE-10;
            }
        }
        if(t[x][s] != -1)
        {
            return t[x][s] ;
        }
        if(c[x] <= s)
        {
            int c1 = fun(c,x+1,s);
            int c2 = 1+fun(c,x,s-c[x]);
            c1 = Math.min(c1,c2);
            return t[x][s] = Math.min(c1,Integer.MAX_VALUE-10);
        }
        else
        {
            return t[x][s] = fun(c,x+1,s);
        }
    }
    
    
    public int coinChange(int[] coins, int amount) {
        t = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        int ans = fun(coins,0,amount);
        if(ans >= Integer.MAX_VALUE-10)
        {
            return -1;
        }
        return ans;
    }
}