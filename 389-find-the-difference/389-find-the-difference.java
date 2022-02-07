class Solution {
    public char findTheDifference(String s, String t) {
        int c[] = new int[26];
        for(int i=0;i<s.length();i++)
        {
            c[s.charAt(i)-'a']--;
        }
        for(int i=0;i<t.length();i++)
        {
            c[t.charAt(i)-'a']++;
            if(c[t.charAt(i)-'a']==1)
            {
                return t.charAt(i);
            }
        }
        return 'a';
    }
}