class Solution {
    public boolean b[][];
    public int t[][];
    
    public boolean pall[][];
    public int t2[][];
    
    public boolean ispal(String s, int l ,int h)
    {
        if(l>=h)
        {
            return true;
        }
        if(t2[l][h] == 1)
        {
            return pall[l][h];
        }
        t2[l][h] = 1;
        boolean ans = false;
        if(s.charAt(l)==s.charAt(h))
        {
            ans = ispal(s,l+1,h-1);
        }
        return pall[l][h] = ans;
    }
    
    
    public boolean fun(String s,int x,int left)
    {
        if(t[x][left]==1)
        {
            return b[x][left];
        }
        boolean ans = false;
        t[x][left] = 1;
        if(left == 0)
        {
            for(int i=x;i<s.length()-2;i++)
            {
                if(ispal(s,x,i))
                {
                    ans = ans || fun(s,i+1,1);
                }
            }
        }
        else
        {
            for(int i=x;i<s.length()-1;i++)
            {
                if(ispal(s,x,i) && ispal(s,i+1,s.length()-1))
                {
                    ans = true;
                    break;
                }
            }
        }
        return b[x][left] = ans;
    }
    
  
    public boolean checkPartitioning(String s) {
        t = new int[s.length()][2];
        b = new boolean[s.length()][2];
        t2 = new int[s.length()][s.length()];
        pall = new boolean[s.length()][s.length()];
        return fun(s,0,0);
    }
}