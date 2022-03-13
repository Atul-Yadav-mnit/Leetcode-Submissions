class Solution {
    List<String> ans;
    HashSet<String> h;
    int max = 0;
    String s;
    public void fun(int x, int open,StringBuilder temp)
    {
        if(x == s.length())
        {
            if(open == 0)
            {
                if(temp.length() == max)
                {
                    if(h.contains(temp.toString()) == false){
                    ans.add(temp.toString());
                    h.add(temp.toString());}
                }
                else if(temp.length() < max)
                {
                    
                }
                else
                {
                    h = new HashSet<String>();
                    h.add(temp.toString());
                    ans = new ArrayList<String>();
                    ans.add(temp.toString());
                    max = temp.length();
                }
                
            }
            return;
        }
        
        
        char c = s.charAt(x);
        if(c == '(')
        {
            // not chhose
            fun(x+1,open,temp);
            temp.append('(');
            fun(x+1,open+1,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        else if(c == ')')
        {
            if(open>0)
            {
                fun(x+1,open,temp);
                temp.append(')');
                fun(x+1,open-1,temp);
                temp.deleteCharAt(temp.length()-1);
            }
            else
            {
                fun(x+1,open,temp);
            }
        }
        else
        {
            temp.append(c);
            fun(x+1,open,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        
        
    }
    public List<String> removeInvalidParentheses(String s) {
        this.s =s;
        h = new HashSet<String>();
        ans = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        fun(0,0,temp);
        return ans;
    }
}