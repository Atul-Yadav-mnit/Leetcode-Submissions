class Solution {
    public boolean t[][],b[][];
    public boolean fun(String s, int i, int j)
    {
        if(i >= j)
        {
            return true;
        }
        if(t[i][j])
        {
            return b[i][j];
        }
        t[i][j] = true;
        if(s.charAt(i)!=s.charAt(j))
        {
            return b[i][j] = false;
        }
        return b[i][j] = fun(s,i+1,j-1);
    }
    public String longestPalindrome(String s) {
        int ans = 0;
        String ss = "";
        int n = s.length();
        t = new boolean[n][n];
        b = new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(fun(s,i,j))
                {
                    int sz = j-i+1;
                    if(sz>ans)
                    {
                        ans = sz;
                        ss = s.substring(i,j+1);
                    }
                }
            }
        }
        return ss;
    }
}