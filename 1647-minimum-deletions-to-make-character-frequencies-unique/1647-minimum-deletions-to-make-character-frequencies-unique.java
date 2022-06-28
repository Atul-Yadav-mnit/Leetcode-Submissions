class Solution {
    public int minDeletions(String s) {
        int c[] = new int[26];
        for(int i=0;i<s.length();i++)
        {
            c[s.charAt(i)-'a']++;
        }
        Arrays.sort(c);
        int ans = 0;
        int count = 0;
        int i = 24;
        for(i=24;i>=0 && c[i]>0;i--)
        {
            if(c[i] == c[i+1])
            {
                count++;
                ans += c[i];
            }
            else
            {
                for(int j=c[i+1]-1;j>c[i] && count>0;j--)
                {
                    count--;
                    ans-=j;
                }
            }
        }
        for(int j=c[i+1]-1;j>0 && count>0;j--)
        {
            count--;
            ans-=j;
        }
        return ans;
    }
}