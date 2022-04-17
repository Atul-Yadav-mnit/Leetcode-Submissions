class Solution {
    public boolean t[][],b[][];
    public boolean fun(String s, int i, int count)
    {
        if(count < 0)
        {
            return false;
        }
        if(i == s.length())
        {
            return count == 0;
        }
        char x = s.charAt(i);
        if(b[i][count])
        {
            
        }
        else if(x == '(')
        {
            t[i][count] = fun(s,i+1,count+1);
        }
        else if(x == ')')
        {
            t[i][count] = fun(s,i+1,count-1);
        }
        else
        {
            t[i][count] = fun(s,i+1,count-1) || fun(s,i+1,count) || fun(s,i+1,count+1);
        }
        b[i][count] = true;
        return t[i][count];
    }
    public boolean checkValidString(String s) {
        t = new boolean[s.length()+1][s.length()+1];
        b = new boolean[s.length()+1][s.length()+1];
        return fun(s,0,0);
    }
}