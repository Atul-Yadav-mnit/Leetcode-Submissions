class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        if(i<s.length() && (s.charAt(i) =='+' || s.charAt(i) =='-') )
        {
            i++;
        }
        boolean ise = false;
        boolean isdot = false;
        boolean isEmpty = true;
        boolean isdigit = false;
        while(i<s.length())
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <='9')
            {
                i++;
                isEmpty = true;
                isdigit = true;
            }
            else if(s.charAt(i) == '.')
            {
                if(ise || isdot)
                {
                    return false;
                }
                else
                {
                    isdot = true;
                    i++;
                }
            }
            else if(s.charAt(i) =='e' || s.charAt(i) == 'E')
            {
                if(!isdigit || ise)
                {
                    return false;
                }
                i++;
                ise = true;
                isEmpty = false;
                if(i<s.length() && s.charAt(i) =='+')
                {
                    i++;
                }
                else if(i<s.length() && s.charAt(i) =='-')
                {
                    i++;
                }
            }
            else
            {
                return false;
            }
        }
        if(!isEmpty && ise)
        {
            return false;
        }
        if(isdot && !isdigit)
        {
            return false;
        }
        return true;
    }
}