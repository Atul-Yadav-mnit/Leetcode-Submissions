class Solution {
    int t[][];
    public int fun(int n, int x)
    {
        if(n == 0)
        {
            return 1;
        }
        if(t[n][x]!=-1)
        {
            return t[n][x];
        }
        int ans = 0;
        for(int i=x;i<5;i++)
        {
            ans += fun(n-1,i);
        }
        return t[n][x] = ans;
    }
    public int countVowelStrings(int n) {
        t = new int[n+1][5];
        for(int i=0;i<n+1;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(n,0);
    }
}