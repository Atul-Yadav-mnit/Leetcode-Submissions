class Solution {
    public int myAtoi(String s) {
        boolean isneg = false;
        int i = 0;
        int cur = 0;
        while(i<s.length())
        {
            if(s.charAt(i) == ' ')
            {
                i++;
            }
            else
            {
                break;
            }
        }
        if(i<s.length() && s.charAt(i) == '-')
        {
            i++;
            isneg = true;
        }
        else if(i<s.length() && s.charAt(i) == '+')
        {
            i++;
        }
        
        while(i<s.length())
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                if(((long)((long)cur*10) + (long)(s.charAt(i)-'0')) > Integer.MAX_VALUE)
                {
                    if(isneg)
                    {
                        return Integer.MIN_VALUE;
                    }
                    else
                    {
                        return Integer.MAX_VALUE;
                    }
                }
                cur = cur*10 + (s.charAt(i)-'0');
                i++;
                
                
            }
            else 
            {
                break;
            }
        }
        if(isneg)
        {
            return -1*cur;
        }
        else
        {
            return cur;
        }
        
    }
}