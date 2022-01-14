class Solution {
    public int fun(String a, String b)
    {
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<25;i++)
        {
            char c = (char)(i+(int)'a');
            int c1 = 0;
            for(int j=0;j<a.length();j++)
            {
                if(a.charAt(j) > c)
                {
                    c1++;
                }
            }
            for(int j=0;j<b.length();j++)
            {
                if(b.charAt(j) <= c)
                {
                    c1++;
                }
            }
            ans = Math.min(ans,c1);
        }
        return ans;
    }
    public int minCharacters(String a, String b) {
        int ans = Integer.MAX_VALUE;
        int ca[] = new int[26];
        int cb[] = new int[26];
        int al[] = new int[26];
        int ar[] = new int[26];
        int bl[] = new int[26];
        int br[] = new int[26];
        for(int j=0;j<a.length();j++)
        {
            ca[a.charAt(j)-'a']++;
        }
        for(int j=0;j<b.length();j++)
        {
            cb[b.charAt(j)-'a']++;
        }

        al[0] = ca[0];
        for(int j=1;j<26;j++)
        {
            al[j] = al[j-1]+ca[j];
        }
          
        ar[25] = ca[25];
        for(int j=24;j>=0;j--)
        {
            ar[j] = ar[j+1]+ca[j];
        }
        bl[0] = cb[0];
        for(int j=1;j<26;j++)
        {
            bl[j] = bl[j-1]+cb[j];
        }
        br[25] = cb[25];
        for(int j=24;j>=0;j--)
        {
            br[j] = br[j+1]+cb[j];
        }
        for(int i=0;i<26;i++)
        {
            ans = Math.min(ans,a.length()+b.length()-ca[i]-cb[i]);
        }
        for(int i=0;i<25;i++)
        {
            int x = a.length()-al[i];
            int y = b.length()-br[i+1];
            ans = Math.min(ans,x+y);
        }
         for(int i=0;i<25;i++)
        {
            int x = a.length()-ar[i+1];
            int y = b.length()-bl[i];
          //   System.out.println(ar[i+1]+" "+y);
            ans = Math.min(ans,x+y);
        }
        return ans;
    }
}