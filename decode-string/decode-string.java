class Solution {
    public int x = 0;
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int cur = 0;
        boolean no = false;
        while(x<s.length())
        {
            if(s.charAt(x) == '[')
            {
                x++;
                String t = decodeString(s);
                for(int i=0;i<cur;i++)
                {
                    ans.append(t);
                }
                cur = 0;
            }
            else if(s.charAt(x) == ']')
            {
                x++;
                return ans.toString();
            }
            else if(s.charAt(x) >= '0' && s.charAt(x)<='9')
            {
                cur = cur*10+s.charAt(x)-'0';
                x++;
            }
            else
            {
                ans.append(s.charAt(x));
                x++;
            }
        }
        return ans.toString();
    }
}