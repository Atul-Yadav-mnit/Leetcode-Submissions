class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
        {
            return s.length();
        }
        int c[] = new int[257];
        int i = 0;
        c[s.charAt(0)] = 1;
        int j = 1;
        int ans = 0;
        while(j<s.length())
        {
            if(c[s.charAt(j)] == 0)
            {
                c[s.charAt(j)]++;
                j++;
            }
            else
            {
                ans = Math.max(ans,j-i);
                c[s.charAt(i)]--;
                i++;
            }
        }
        ans = Math.max(ans,j-i);
        return ans;
        
    }
}