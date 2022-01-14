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
        int c[] = new int[26];
        for(int j=0;j<a.length();j++)
        {
            c[a.charAt(j)-'a']++;
        }
        for(int j=0;j<b.length();j++)
        {
            c[b.charAt(j)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            ans = Math.min(ans,a.length()+b.length()-c[i]);
        }
        ans = Math.min(fun(a,b),ans);
        ans = Math.min(fun(b,a),ans);
        return ans;
    }
}