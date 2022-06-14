class Solution {
    int t[][];
    public int fun(String a, String b, int x, int y)
    {
        if(x == -1)
        {
            return y+1;
        }
        else if(y == -1)
        {
            return x+1;
        }
        else
        {
            if(t[x][y]!=-1)
            {
                return t[x][y];
            }
            else if(a.charAt(x) == b.charAt(y))
            {
                return t[x][y] = fun(a,b,x-1,y-1);
            }
            return t[x][y] = 1+Math.min(fun(a,b,x-1,y),fun(a,b,x,y-1));
        }
    }
    
    public int minDistance(String word1, String word2) {
        t = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(word1,word2,word1.length()-1,word2.length()-1);
    }
}