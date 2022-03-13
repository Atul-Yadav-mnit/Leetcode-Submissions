class Solution {
    public boolean isValid(String st) {
        int a = 0,b = 0,c = 0;
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<st.length();i++)
        {
            char x = st.charAt(i);
            if(x == 'a')
            {
                s.push('c');
                s.push('b');
            }
            else if(x == 'b')
            {
                if(s.isEmpty() || s.peek()!='b')
                {
                    return false;
                }
                s.pop();
            }
            else
            {
                if(s.isEmpty() || s.peek()!='c')
                {
                    return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }
}