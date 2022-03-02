class Solution {
    public boolean isSubsequence(String t, String s) {
        int i = 0;
        int j = 0;
        if(t.length()==0)
        {
            return true;
        }
        while(i<s.length() && j<t.length())
        {
            if(s.charAt(i) == t.charAt(j))
            {
                j++;
            }
            if(j == t.length())
            {
                return true;
            }
            i++;
        }
        return false;
    }
}