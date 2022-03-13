class Solution {
    public boolean isValid(String st) {
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<st.length();i++)
        {
            char x = st.charAt(i);
            if(x == '(' || x == '[' || x=='{')
            {
                s.push(x);
            }
            else if(x == ')')
            {
                if(s.isEmpty())
                {
                    return false;
                }
                if(s.pop() !='(')
                {
                    return false;
                }
            }
             else if(x == '}')
            {
                if(s.isEmpty())
                {
                    return false;
                }
                if(s.pop() !='{')
                {
                    return false;
                }
            }
             else if(x == ']')
            {
                if(s.isEmpty())
                {
                    return false;
                }
                if(s.pop() !='[')
                {
                    return false;
                }
            }
            
        }
        if(!s.isEmpty())
        {
            return false;
        }
        return true;
    }
}