class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);
            if(x>='a' && x<='z')
            {
                temp.append(x);
            }
            else if(x >='A' && x<='Z')
            {
                x = (char)(x-'A'+'a');
                temp.append(x);
            }
            else if(x>='0' && x<='9')
            {
                temp.append(x);
            }
        }
        s = temp.toString();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
            {
                return false;
            }
        }
        return true;
    }
}