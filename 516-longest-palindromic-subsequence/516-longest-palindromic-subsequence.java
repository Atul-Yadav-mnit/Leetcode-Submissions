class Solution {
    public int t[][];
    public int fun(String s, int i, int j)
    {  
        if(i>j)
        {
            return  0; 
        }
        if(i == j)
        {
            return 1;
        }
        if(t[i][j]!=-1)
        {
            return t[i][j];
        }
        if(s.charAt(i) == s.charAt(j))
        {
            return t[i][j] = 2+fun(s,i+1,j-1);
        }
        else
        {
            return t[i][j] = Math.max(fun(s,i+1,j) ,fun(s,i,j-1));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        t = new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(s,0,s.length()-1);           
    }
}