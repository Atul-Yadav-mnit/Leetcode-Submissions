class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> a = new Stack<Character>();
        Stack<Character> b = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='#')
            {
                if(!a.isEmpty())
                {
                    a.pop();
                }
            }
            else
            {
                a.push(s.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='#')
            {
                if(!b.isEmpty())
                {
                    b.pop();
                }
            }
            else
            {
                b.push(t.charAt(i));
            }
        }
        if(a.size()!=b.size())
        {
            return false;
        }
        while(a.size()>0)
        {
            if(a.pop()!=b.pop())
            {
                return false;
            }
        }
        return true;
    }
}