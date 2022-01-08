class Solution {
    public int t[][];
    public int num(String s, int l ,int h)
    {
        int c = 0;
        while(l<h)
        {
            if(s.charAt(l)!=s.charAt(h))
            {
                c++;
            }
            l++;
            h--;
        }
        return c;
    }
    public int fun(String s, int x, int k)
    {
        if(x == s.length())
        {
            if(k == 0)
            {
                return 0;
            }
            else
            {
                return 100000;
            }
        }
        if(k == 0)
        {
            return 100000;
        }
        if(t[x][k]!=-1)
        {
            return t[x][k];
        }
        int ans = 100000;
        for(int i=x;i<s.length();i++)
        {
            int y = num(s,x,i);
            ans = Math.min(ans,y+fun(s,i+1,k-1));
        }
        return t[x][k] = ans;
    }
    public int palindromePartition(String s, int k) {
        t = new int[s.length()][k+1];
        for(int i=0;i<s.length();i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(s,0,k);
    }
}