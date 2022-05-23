class Solution {
    int one[],zero[];
    int t[][][];
    public int fun(int x, int m, int n)
    {
        if(x == one.length)
        {
            if(m>=0 && n>=0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(!(m>=0 && n>=0))
        {
            return 0;
        }
        if(t[x][m][n] != -1)
        {
            return t[x][m][n];
        }
        return t[x][m][n] = Math.max( fun(x+1,m,n) , 1+fun(x+1,m-zero[x],n-one[x]) ); 
    }
    public int findMaxForm(String[] s, int m, int n) {
        int x = s.length;
        t = new int[x][m+1][n+1];
        one = new int[x];
        zero = new int[x];
        for(int i=0;i<x;i++)
        {
            int y = 0;
            for(int j=0;j<s[i].length();j++)
            {
                if(s[i].charAt(j) == '1')
                {
                    y++;
                }
            }
            one[i] = y;
            zero[i] = s[i].length()-y;
          //  System.out.println(one[i]+ " "+zero[i]);
        }
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        return fun(0,m,n)-1;
    }
    
}