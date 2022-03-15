class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int count2 = 0;
        StringBuilder temp = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i) == ')')
            {
                count2++;
            }
            
        }
        
        for(int i=0;i<s.length();i++)
        {
            
            if(s.charAt(i) == ')')
            {
                if(open>0)
                {
                     open--;
                    temp.append(')');
                  
                }
                  count2--;
            }
            else if(s.charAt(i) == '(')
            {
                if(open+1 <= count2)
                {
                    open++;
                    temp.append('(');
                }
            }
            else
            {
                temp.append(s.charAt(i));
            }
        }
        return temp.toString();
    }
}