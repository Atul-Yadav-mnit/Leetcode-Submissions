class Solution {
    boolean t[][],b[][];
    boolean fun(String s, int x, int y)
    {
        if(x >= y)
        {
            return true;
        }
        if(b[x][y])
        {
            return t[x][y];
        }
        b[x][y] = true;
        return t[x][y] = s.charAt(x) == s.charAt(y) && fun(s,x+1,y-1);
    }
    public int countSubstrings(String s) {
        int n = s.length();
        b = new boolean[n][n];
        t = new boolean[n][n];
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(fun(s,i,j))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}