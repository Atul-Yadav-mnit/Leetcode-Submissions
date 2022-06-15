class Solution {
    int t[];
    public boolean compares(String x, String y)
    {
        int j = 0;
        boolean isa = true;
        if(x.length()+1 != y.length())
        {
            return false;
        }
       // System.out.println(x+" "+y);
        for(int i=0;i<x.length();i++)
        {
            if(y.charAt(j) != x.charAt(i) && isa)
            {
                j++;
                i--;
                isa = false;
            }
            else if(y.charAt(j) != x.charAt(i) && !isa)
            {
              //  System.out.println("false");
                return false;
            }
            else
            {
                j++;
            }
        }
      //  System.out.println("true");
        return true;
    }
    public int fun(String words[], int x)
    {
        if(x == words.length)
        {
            return 0;
        }
        if(t[x]!=-1)
        {
            return t[x];
        }
        int ans = 0;
        for(int i=x+1;i<words.length;i++)
        {
            //System.out.println(x+" "+i);
            if(compares(words[x],words[i]))
            {
               // System.out.println("Done"+x+" "+i);
                ans = Math.max(ans,1+fun(words,i));
            }
        }
        return t[x] = ans;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(w1,w2) -> w1.length()-w2.length());
        t=  new int[words.length];
        Arrays.fill(t,-1);
        int ans = 0;
        for(int i=0;i<words.length;i++)
        {
            ans = Math.max(ans,1+fun(words,i));
        }
        return ans;
    }
}