class Solution {
    public int t[][][];
    public int fun(ArrayList<Integer> zero,ArrayList<Integer> one,int x, int m, int n)
    {
        int i = x;
        if(x == zero.size())
        {
            return 0;
        }
        if(t[x][m][n]!=-1)
        {
            return t[x][m][n];
        }
        if(zero.get(i)<=m && one.get(i)<=n)
        {
            int z = fun(zero,one,x+1,m,n);
            int y = 1+fun(zero,one,x+1,m-zero.get(i),n-one.get(i));
            return t[x][m][n] = Math.max(z,y);
        }
        else
        {
            return t[x][m][n] = fun(zero,one,x+1,m,n);
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        t = new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<=m;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        
        ArrayList<Integer> one = new ArrayList<Integer>();
        ArrayList<Integer> zero = new ArrayList<Integer>();
        for(int i=0;i<strs.length;i++)
        {
            int cz = 0, co = 0;
            for(int j=0;j<strs[i].length();j++)
            {
                if(strs[i].charAt(j) == '0')
                {
                    cz++;
                }
                else
                {
                    co++;
                }
            }
            one.add(co);
            zero.add(cz);
        }
        return fun(zero,one,0,m,n);
        
    }
}